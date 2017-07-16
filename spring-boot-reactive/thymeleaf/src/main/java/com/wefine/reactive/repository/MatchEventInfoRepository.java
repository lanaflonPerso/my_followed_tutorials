package com.wefine.reactive.repository;


import com.wefine.reactive.business.dataviews.MatchEventInfo;
import com.wefine.reactive.entity.MatchEvent;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class MatchEventInfoRepository {


    private final PlayerInfoRepository playerInfoRepository;
    private final ReactiveMongoTemplate mongoTemplate;


    public MatchEventInfoRepository(
            final PlayerInfoRepository playerInfoRepository,
            final ReactiveMongoTemplate mongoTemplate) {
        super();
        this.playerInfoRepository = playerInfoRepository;
        this.mongoTemplate = mongoTemplate;
    }


    public Flux<MatchEventInfo> tailAllMatchEventInfoByMatchId(final String matchId) {
        return this.mongoTemplate.tail(queryForMatchId(matchId),MatchEvent.class).concatMap(this::buildMatchEventInfo);
    }


    public Flux<MatchEventInfo> findAllMatchEventInfoByMatchId(final String matchId) {
        return this.mongoTemplate.find(queryForMatchId(matchId),MatchEvent.class).concatMap(this::buildMatchEventInfo);
    }


    private Mono<MatchEventInfo> buildMatchEventInfo(final MatchEvent event) {
        // For a specific Match, gets the info of the playing teams and creates the MatchInfo
        if (event.getPlayerId() == null) {
            // This is a START_MATCH event
            return Mono.just(new MatchEventInfo(event.getType(), null, event.getTimestamp()));
        }
        return this.playerInfoRepository.getPlayerInfo(event.getPlayerId())
                .map(playerInfo -> new MatchEventInfo(event.getType(), playerInfo, event.getTimestamp()));
    }


    private static Query queryForMatchId(final String matchId) {
        return Query.query(Criteria.where("matchId").is(matchId));
    }


}
