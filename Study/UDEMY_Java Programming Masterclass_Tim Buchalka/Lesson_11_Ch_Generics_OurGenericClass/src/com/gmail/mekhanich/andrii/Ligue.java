package com.gmail.mekhanich.andrii;

import java.awt.*;
import java.util.*;

public class Ligue <T extends PlayTeam> {
    private String name;
    private ArrayList<Team <T>> ligue = new ArrayList<>();



    public Ligue(String name) {
        this.name = name;
    }

    public boolean addTeam (Team<T>team){
        if(team.getTeamSize() >= 2){
            ligue.add(team);
            return true;
        } else {
            System.out.println("Should be at least two members!");
            return false;
        }
    }

    public void ligueTeamChart (){

        LinkedList <Team <T>> ligueChart = new LinkedList<>();

        for(int i = 0; i< this.ligue.size(); i++){
            System.out.println(this.ligue.get(i));
            ligueChart.add(this.ligue.get(i));
        }

        Collections.sort(ligueChart, new Comparator<Team<T>>() {
            @Override
            public int compare(Team<T> o1, Team<T> o2) {
                if(o1.getRang()>o2.getRang()){
                    return -1;
                } else if(o1.getRang()<o2.getRang()){
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        System.out.println(ligueChart);
    }

}
