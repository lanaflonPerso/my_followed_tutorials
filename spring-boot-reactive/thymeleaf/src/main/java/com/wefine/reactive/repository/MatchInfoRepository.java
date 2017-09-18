package com.wefine.reactive.repository;


import com.wefine.reactive.business.dataviews.MatchInfo;
import com.wefine.reactive.entity.Match;
import com.wefine.reactive.entity.Team;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class MatchInfoRepository {


    private final ReactiveMongoTemplate mongoTemplate;


    public MatchInfoRepository(final ReactiveMongoTemplate mongoTemplate) {
        super();
        this.mongoTemplate = mongoTemplate;
    }



    public Mono<MatchInfo> getMatchInfo(final String matchId) {
        return this.mongoTemplate.findById(matchId, Match.class).flatMap(this::buildMatchInfo);
    }


    public Flux<MatchInfo> findAllMatchInfo() {
        return this.mongoTemplate.findAll(Match.class).concatMap(this::buildMatchInfo);
    }


    private Mono<MatchInfo> buildMatchInfo(final Match match) {
        // For a specific Match, gets the info of the playing teams and creates the MatchInfo
        return this.mongoTemplate.findById(match.getTeamACode(), Team.class)
                .zipWith(this.mongoTemplate.findById(match.getTeamBCode(), Team.class))
                .map(teams -> new MatchInfo(match.getId(), teams.getT1(), teams.getT2()));
    }

}
