package com.adamhosman;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Set<String> setA = new HashSet<>(Arrays.asList("i am a string and id like to be split please".split(" ")));
        Set<String> setB = new HashSet<>(Arrays.asList("i am also a string and im very hungry however weird that is".split(" ")));

        /* Union of setA & setB */
        Set<String> union = new HashSet<>();
        union.addAll(setA);
        union.addAll(setB);
        System.out.println("                Union: " + union);

        /* Intersection of setA & setB */
        Set<String> intersection = new HashSet<>();
        intersection.addAll(setA);
        intersection.retainAll(setB);
        System.out.println("         Intersection: " + intersection);

        /* Symmetric difference of setA & setB */
        Set<String> symmetricDifference = new HashSet<>();
        symmetricDifference.addAll(setA);
        symmetricDifference.addAll(setB);
        symmetricDifference.removeAll(intersection);
        System.out.println(" Symmetric difference: " + symmetricDifference);

        /* Asymmetric difference of setA & setB */
        Set<String> asymmetricDifference = new HashSet<>();
        asymmetricDifference.addAll(setA);
        asymmetricDifference.removeAll(setB);
        System.out.println("Asymmetric difference: " + asymmetricDifference);
    }

}
