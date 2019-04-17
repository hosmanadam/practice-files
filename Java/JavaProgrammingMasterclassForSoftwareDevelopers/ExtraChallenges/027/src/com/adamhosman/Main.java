package com.adamhosman;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }

    public static void inputThenPrintSumAndAverage() {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int count = 0;
        while (true) {
            boolean hasNextInt = scanner.hasNextInt();
            if (hasNextInt) {
                int nextInt = scanner.nextInt();
                sum += nextInt;
                count++;
                scanner.nextLine();
            } else {
                scanner.close();
                break;
            }
        }
        long average = Math.round(sum / (double) (count));
        System.out.println("SUM = " + sum + " AVG = " + average);
    }

}
