package com.adamhosman;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {

    private String name;
    private ArrayList<T> teams;

    public League(String name, ArrayList<T> teams) {
        this.name = name;
        this.teams = teams;
    }

    public League(String name) {
        this.name = name;
    }

    public void addTeam(T team) {
        teams.add(team);
    }

    public void display() {
        sort();
        System.out.println(toString());
    }

    public void sort() {
        Collections.sort(teams, Collections.reverseOrder());
    }

    @Override
    public String toString() {
        String repr = getClass().getSimpleName() + " '" + name + "'" + " {";
        for (T team : teams) {
            repr += "\n    " + team.toString();
        }
        repr += "\n}";
        return repr;
    }

}
