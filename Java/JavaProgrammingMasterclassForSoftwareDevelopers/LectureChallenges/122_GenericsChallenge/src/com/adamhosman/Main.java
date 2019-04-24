package com.adamhosman;

import java.util.ArrayList;

/**
 * Create a generic class to implement a league table for a sport.
 * The class should allow teams to be added to the list, and store
 * a list of teams that belong to the league.
 *
 * Your class should have a method to print out the teams in order,
 * with the team at the top of the league printed first.
 *
 * Only teams of the same type should be added to any particular
 * instance of the league class - the program should fail to compile
 * if an attempt is made to add an incompatible team.
 */
public class Main {

    public static void main(String[] args) {
        Team<Quidditch> Q1 = new Team<>("Quidditch One", 3);
        Team<Quidditch> Q2 = new Team<>("Quidditch Two", 2);
        Team<Quidditch> Q3 = new Team<>("Quidditch Three", 1);
        Team<Quidditch> Q4 = new Team<>("Quidditch Four", 4);

        Team<UnderwaterHockey> UH1 = new Team<>("Underwater Hockey One", 20);
        Team<UnderwaterHockey> UH2 = new Team<>("Underwater Hockey Two", 4);
        Team<UnderwaterHockey> UH3 = new Team<>("Underwater Hockey Three", 44);
        Team<UnderwaterHockey> UH4 = new Team<>("Underwater Hockey Four", 14);

        League<Team<Quidditch>> leagueOfQ= new League<>("League Of Quidditch", new ArrayList<>(){{
            add(Q1); add(Q2); add(Q3); add(Q4);
        }});
        leagueOfQ.display();

        League<Team<UnderwaterHockey>> leagueOfUH = new League<>("League of Underwater Hockey", new ArrayList<>(){{
            add(UH1); add(UH2); add(UH3); add(UH4);
        }});
        leagueOfUH.display();

        League leagueOfMixed= new League<>("League Of Mixed", new ArrayList<>(){{
            add(Q1); add(Q2); add(UH3); add(UH4);
        }});
        leagueOfMixed.display();

//        League<Team<UnderwaterHockey>> leagueOfError = new League<>("League of Error", new ArrayList<>(){{
//            add(Q1); add(Q2); add(UH3); add(UH4);
//        }});
//        leagueOfError.display();

    }

}
