package com.adamhosman;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        printMinAndMaxInput();
    }

    public static void printMinAndMaxInput() {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter any numbers you like. When you're done, type 'OK'.");
        while (true) {
            boolean hasNextInt = scanner.hasNextInt();
            if (hasNextInt) {
                int nextInt = scanner.nextInt();
                scanner.nextLine();
                if (nextInt > max)
                    max = nextInt;
                if (nextInt < min)
                    min = nextInt;
            } else {
                scanner.close();
                break;
            }
        }
        System.out.println("Smallest number: " + min);
        System.out.println("Largest number: " + max);
    }

}
