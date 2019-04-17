package com.adamhosman;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	sumInputs(5);
    }

    public static void sumInputs(int howMany) {
    	Scanner scanner = new Scanner(System.in);
        int sum = 0;
    	for (int i=1; i<=howMany; i++) {
            System.out.println("Please enter number #" + i + ":");
    	    boolean hasNextInt = scanner.hasNextInt();
    	    if (hasNextInt) {
                int nextInt = scanner.nextInt();
    	        sum += nextInt;
            } else {
                System.out.println("Not a number, try again...");

                i--;
            }
            scanner.nextLine();
        }
        System.out.println("Total is " + sum + ".");
    	scanner.close();
    }

}
