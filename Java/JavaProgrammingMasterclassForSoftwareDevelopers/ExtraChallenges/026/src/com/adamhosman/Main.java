package com.adamhosman;

public class Main {

    public static void main(String[] args) {
        printSquareStar(9);
    }

    public static void printSquareStar(int number) {
        if (number < 5) {
            System.out.println("Invalid Value");
        } else {
            for (int row = 1; row <= number; row++) {
                for (int column = 1; column <= number; column++) {
                    if ((row == 1) || (row == number) || (column == 1) || (column == number) || (row == column) || (row == number - column + 1)) {
                        System.out.print('*');
                    } else {
                        System.out.print(' ');
                    }
                }
                if (row != number)
                    System.out.println();
            }
        }
    }

}
