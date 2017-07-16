package com.wefine.reactive.business.dataviews;


import com.wefine.reactive.entity.Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MatchStatus {

    private final MatchInfo matchInfo;
    private final int teamAScore;
    private final int teamBScore;
    private final List<MatchEventInfo> events;


    public MatchStatus(
            final MatchInfo matchInfo,
            final int teamAScore, final int teamBScore,
            final List<MatchEventInfo> events) {
        super();
        this.matchInfo = matchInfo;
        this.teamAScore = teamAScore;
        this.teamBScore = teamBScore;
        final List<MatchEventInfo> statusEvents = new ArrayList<>(events);
        Collections.sort(statusEvents);
        this.events = Collections.unmodifiableList(statusEvents);
    }

    public String getMatchId() {
        return this.matchInfo.getMatchId();
    }

    public Team getTeamA() {
        return this.matchInfo.getTeamA();
    }

    public Team getTeamB() {
        return this.matchInfo.getTeamB();
    }

    public String getTeamACode() {
        return getTeamA().getCode();
    }

    public String getTeamBCode() {
        return getTeamB().getCode();
    }

    public String getTeamAName() {
        return getTeamA().getName();
    }

    public String getTeamBName() {
        return getTeamB().getName();
    }

    public int getTeamAScore() {
        return this.teamAScore;
    }

    public int getTeamBScore() {
        return this.teamBScore;
    }

    public List<MatchEventInfo> getEvents() {
        return this.events;
    }


    @Override
    public String toString() {
        return "MatchStatus{" +
                "matchInfo='" + this.matchInfo + '\'' +
                ", teamAScore=" + this.teamAScore +
                ", teamBScore=" + this.teamBScore +
                ", events=" + this.events +
                '}';
    }

}
