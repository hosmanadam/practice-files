package com.adamhosman;

public class Main {

    public static void main(String[] args) {
    	printFactors(123);
    }

    public static void printFactors(int number) {
        if (number < 1) {
            System.out.println("Invalid Value");
        } else {
            int candidate = 1;
            while (candidate <= number) {
                if (number % candidate == 0)
                    System.out.println(candidate);
                candidate++;
            }
        }
    }

}
