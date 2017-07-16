package com.wefine.reactive.business.dataviews;


import com.wefine.reactive.entity.Team;

public class PlayerInfo {

    private final String id;
    private final Team team;
    private final String name;


    public PlayerInfo(final String id, final Team team, final String name) {
        super();
        this.id = id;
        this.team = team;
        this.name = name;
    }


    public String getId() {
        return this.id;
    }

    public Team getTeam() {
        return this.team;
    }

    public String getTeamName() {
        return this.getTeam().getName();
    }

    public String getName() {
        return this.name;
    }


    @Override
    public String toString() {
        return "PlayerInfo{" +
                "id='" + this.id + '\'' +
                ", team=" + this.team +
                ", name='" + this.name + '\'' +
                '}';
    }

}
