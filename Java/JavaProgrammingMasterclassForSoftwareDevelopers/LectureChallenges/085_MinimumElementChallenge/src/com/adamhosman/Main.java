package com.adamhosman;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = getCount(scanner);
        int[] intArray = readIntegers(scanner, count);
        int min = findMin(intArray);
        System.out.println("The smallest number you typed is " + min + ".");
        scanner.close();
    }

    public static int[] readIntegers(Scanner scanner, int howMany) {
        System.out.println("Type " + howMany + " numbers:");
        int[] intArray = new int[howMany];
        for (int i=0; i<howMany; i++) {
            intArray[i] = getInt(scanner);
            scanner.nextLine();
        }
        return intArray;
    }

    public static int findMin(int[] intArray) {
        int min = Integer.MAX_VALUE;
        for (int integer : intArray) {
            if (integer < min) {
                min = integer;
            }
        }
        return min;
    }

    public static int getCount(Scanner scanner) {
        int count;
        System.out.println("How many numbers will you type?");
        count = getInt(scanner);
        scanner.nextLine();
        return count;
    }

    public static int getInt(Scanner scanner) {
        System.out.print("→ ");
        while (!scanner.hasNextInt()) {
            System.out.print("Not a number, try again!\n→ ");
            scanner.nextLine();
        }
        return scanner.nextInt();
    }

}
