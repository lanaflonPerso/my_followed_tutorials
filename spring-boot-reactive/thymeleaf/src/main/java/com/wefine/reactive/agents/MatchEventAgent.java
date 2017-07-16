package com.wefine.reactive.agents;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;


import com.wefine.reactive.entity.Match;
import com.wefine.reactive.entity.MatchEvent;
import com.wefine.reactive.entity.Player;
import com.wefine.reactive.util.MatchEventUtils;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MatchEventAgent {

	private static final String LOGGER_AGENT = MatchEventAgent.class.getName() + ".EVENTS";

	private static final Duration EVENT_INTERVAL = Duration.ofSeconds(4);

	private final ReactiveMongoTemplate mongoTemplate;
	private final Random random;

	public MatchEventAgent(final ReactiveMongoTemplate mongoTemplate) {
		super();
		this.random = new Random(System.currentTimeMillis());
		this.mongoTemplate = mongoTemplate;
	}




	public Flux<MatchEvent> createAgentStream() {
		return Flux.interval(EVENT_INTERVAL).concatMap(delay -> insertNewEvent());
	}



	private Mono<MatchEvent> insertNewEvent() {
		// Will insert a new event for a random match and player (of that match)
		final Mono<Match> match = chooseMatch();
		return match.flatMap(this::createEvent)
				    .flatMap(this.mongoTemplate::insert)
				    .log(LOGGER_AGENT, Level.FINEST);
	}



	private Mono<Match> chooseMatch() {
		// Will randomly select a match from the ones on the database
		return this.mongoTemplate.findAll(Match.class).collectList().map(this::randomFromList);
	}


	private Mono<MatchEvent> createEvent(final Match match) {
		// Will create a match event of a random type for the selected match (and a random player)
		final Query query =
				Query.query(
						new Criteria().orOperator(
								Criteria.where("teamCode").is(match.getTeamACode()),
								Criteria.where("teamCode").is(match.getTeamBCode())));

		final Flux<Player> playersForMatch =
				this.mongoTemplate.find(query, Player.class);

		final Mono<Player> chosenPlayer =
				playersForMatch.collectList().map(this::randomFromList);

		return chosenPlayer.map(
				p -> new MatchEvent(match.getId(), MatchEventUtils.randomEventType(), p.getTeamCode(), p.getId()));
	}


	private <T> T randomFromList(final List<T> list) {
		return list.get(this.random.nextInt(list.size()));
	}



}
