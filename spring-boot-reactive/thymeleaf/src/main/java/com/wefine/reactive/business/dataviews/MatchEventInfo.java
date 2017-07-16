package com.wefine.reactive.business.dataviews;


import com.wefine.reactive.entity.MatchEvent;

public class MatchEventInfo implements Comparable<MatchEventInfo> {

    private final MatchEvent.Type type;
    private final PlayerInfo playerInfo;
    private final String timestamp;


    public MatchEventInfo(final MatchEvent.Type type, final PlayerInfo playerInfo, final String timestamp) {
        super();
        this.type = type;
        this.playerInfo = playerInfo;
        this.timestamp = timestamp;
    }

    public MatchEvent.Type getType() {
        return type;
    }

    public PlayerInfo getPlayerInfo() {
        return playerInfo;
    }

    public String getPlayerName() {
        return getPlayerInfo().getName();
    }

    public String getTeamCode() {
        return getPlayerInfo().getTeam().getCode();
    }

    public String getTeamName() {
        return getPlayerInfo().getTeamName();
    }

    public String getTimestamp() {
        return this.timestamp;
    }



    @Override
    public int compareTo(final MatchEventInfo o) {
        return -1 * this.timestamp.compareTo(o.timestamp);
    }


    @Override
    public String toString() {
        return "MatchEventInfo{" +
                "type=" + this.type +
                ", playerInfo=" + this.playerInfo +
                '}';
    }

}
