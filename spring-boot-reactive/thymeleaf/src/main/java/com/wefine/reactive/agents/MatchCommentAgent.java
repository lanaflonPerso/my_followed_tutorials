
package com.wefine.reactive.agents;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;

import com.wefine.reactive.entity.Match;
import com.wefine.reactive.entity.MatchComment;
import com.wefine.reactive.util.MatchCommentUtils;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MatchCommentAgent {

	private static final String LOGGER_AGENT = MatchCommentAgent.class.getName() + ".EVENTS";

	private static final Duration EVENT_INTERVAL = Duration.ofSeconds(2);


	private final ReactiveMongoTemplate mongoTemplate;
	private final Random random;


	public MatchCommentAgent(final ReactiveMongoTemplate mongoTemplate) {
		super();
		this.random = new Random(System.currentTimeMillis());
		this.mongoTemplate = mongoTemplate;
	}

	public Flux<MatchComment> createAgentStream() {
		return Flux.interval(EVENT_INTERVAL).concatMap(delay -> insertNewEvent());
	}

	private Mono<MatchComment> insertNewEvent() {
		// Will insert a new comment for a random match
		final Mono<Match> match = chooseMatch();
		return match.map(m -> new MatchComment(m.getId(), MatchCommentUtils.randomAuthor(), MatchCommentUtils.randomText()))
				.flatMap(this.mongoTemplate::insert)
				.log(LOGGER_AGENT, Level.FINEST);
	}

	private Mono<Match> chooseMatch() {
		// Will randomly select a match from the ones on the database
		return this.mongoTemplate.findAll(Match.class).collectList().map(this::randomFromList);
	}

	private <T> T randomFromList(final List<T> list) {
		return list.get(this.random.nextInt(list.size()));
	}

}
