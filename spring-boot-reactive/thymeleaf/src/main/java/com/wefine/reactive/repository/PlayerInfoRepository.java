package com.wefine.reactive.repository;


import com.wefine.reactive.business.dataviews.PlayerInfo;
import com.wefine.reactive.entity.Player;
import com.wefine.reactive.entity.Team;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class PlayerInfoRepository {


    private final ReactiveMongoTemplate mongoTemplate;


    public PlayerInfoRepository(final ReactiveMongoTemplate mongoTemplate) {
        super();
        this.mongoTemplate = mongoTemplate;
    }


    public Mono<PlayerInfo> getPlayerInfo(final String playerId) {
        return this.mongoTemplate.findById(playerId, Player.class).flatMap(this::buildPlayerInfo);
    }



    private Mono<PlayerInfo> buildPlayerInfo(final Player player) {
        // For a specific Player, gets the info of the associated team
        return this.mongoTemplate.findById(player.getTeamCode(), Team.class)
                .map(team -> new PlayerInfo(player.getId(), team, player.getName()));
    }

}
