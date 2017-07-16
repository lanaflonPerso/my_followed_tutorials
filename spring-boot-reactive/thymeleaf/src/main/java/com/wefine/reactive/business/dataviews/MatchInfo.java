package com.wefine.reactive.business.dataviews;


import com.wefine.reactive.entity.Team;

public class MatchInfo {

    private final String matchId;
    private final Team teamA;
    private final Team teamB;


    public MatchInfo(final String matchId, final Team teamA, final Team teamB) {
        super();
        this.matchId = matchId;
        this.teamA = teamA;
        this.teamB = teamB;
    }

    public String getMatchId() {
        return this.matchId;
    }

    public Team getTeamA() {
        return this.teamA;
    }

    public Team getTeamB() {
        return this.teamB;
    }


    @Override
    public String toString() {
        return "MatchInfo{" +
                "matchId='" + this.matchId + '\'' +
                ", teamA=" + this.teamA +
                ", teamB=" + this.teamB +
                '}';
    }

}
