package com.gmsil.mekhanich.andrii;

import java.util.ArrayList;


//public class Team<T extends Player & Coach & Manager>
public class Team<T extends Player> implements Comparable<Team<T>> {
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player) {
        if (members.contains(player)) {
//            System.out.println(((Player)player).getName() + " already exsts in team!");
            System.out.println(player.getName() + " already exsts in team!");
            return false;
        } else {
            members.add(player);
//            System.out.println(((Player)player).getName() + " successfully added to the team! "
            System.out.println(player.getName() + " successfully added to the team! "
                    + this.name);
            return true;
        }
    }

    public int numPlayers() {
        return this.members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {
        String message;
        if (ourScore > theirScore) {
            won++;
            message = " BEAT ";
        } else if (ourScore < theirScore) {
            lost++;
            message = " LOST TO ";
        } else {
            tied++;
            message = " drew with ";
        }
        played++;

        if (opponent != null) {
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking() {
        return won * 2 + tied;
    }

    @Override
    public int compareTo(Team<T> team) {
        if(this.ranking() > team.ranking()){
            return -1;
        } else if (this.ranking() < team.ranking()) {
            return 1;
        } else {
            return 0;
        }
    }
}
