package com.adamhosman;

public class Team<Sport> implements Comparable<Team<Sport>> {

    private String name;
    private int score;
    private Sport sport;

    public Team(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int compareTo(Team<Sport> otherTeam) {
        return score - otherTeam.getScore();
    }

    public boolean equals(Team<Sport> otherTeam) {
        return otherTeam.getScore() == score;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " '" + name + "': score " + score;
    }

}
