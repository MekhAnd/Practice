package com.gmail.mekhanich.andrii;

import java.util.ArrayList;

public class Team<T extends PlayTeam> {
    private String name;
    private double rang = 0;
    int win;
    int loose;
    int draw;
    int globalGames;


    ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    private void setRang(double rang) {
        this.rang = rang;
    }

    public double getRang() {
        return rang;
    }

    public String getName() {
        return name;
    }

    public ArrayList<T> getMembers() {
        return members;
    }

    public boolean addNewMember(T member) {
        if (member == null || this.members.contains(member)) {
            System.out.println("Unf impossible");
            return false;
        } else {
            members.add(member);
            System.out.println("Successfully");
            return true;
        }
    }

    public int getTeamSize(){
        return this.getMembers().size();
    }

    public void matchResult(Team<T> team, int ourScore, int theirScore) {
        String message;
        if (ourScore > theirScore) {
            win++;
            message = " BEAT ";
        } else if (ourScore < theirScore) {
            loose++;
            message = " LOST TO ";
        } else {
            draw++;
            message = " drew with ";
        }
        globalGames++;
        this.ranking();

        if (team != null) {
            System.out.println(this.getName() + message + team.getName());
            team.matchResult(null, theirScore, ourScore);
            team.ranking();
        }
    }

    public void ranking(){
        this.setRang(win*2 - loose*2 + draw*0.5);
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", rang=" + rang +
                                '}';
    }
}
