package com.adamhosman;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] sorted = sortIntArray(getIntegers(5));
        System.out.println("Let me sort that for you: ");
        printIntArray(sorted);
    }

    public static int[] getIntegers(int howMany) {
        System.out.println("Type " + howMany + " numbers:");
        Scanner scanner = new Scanner(System.in);
        int[] intArray = new int[howMany];
        for (int i=0; i<howMany; i++) {
            boolean hasNextInt = scanner.hasNextInt();
            if (hasNextInt) {
                intArray[i] = scanner.nextInt();
            } else {
                System.out.println("Not a number, try again:");
                i--;
            }
            scanner.nextLine();
        }
        return intArray;
    }

    public static void printIntArray(int[] intArray) {

        for (int integer : intArray) {
            System.out.println(integer);
        }
    }

    public static int[] sortIntArray(int[] intArray) {
        int[] sorted = intArray.clone();
        int temp;
        boolean needToSort = true;
        while (needToSort) {
            needToSort = false;
            for (int j=0; j<sorted.length-1; j++) {
                if (sorted[j] < sorted[j+1]) {
                    temp = sorted[j];
                    sorted[j] = sorted[j+1];
                    sorted[j+1] = temp;
                    needToSort = true;
                }
            }
        }
        return sorted;
    }

}
