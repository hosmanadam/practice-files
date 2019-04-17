package com.adamhosman;

public class Main {

    public static void main(String[] args) {
        System.out.println(calcFeetAndInchesToCentimeters(3.44));
        System.out.println(calcFeetAndInchesToCentimeters(2, 3.44));
    }

    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {
        if ((feet < 0) || (inches < 0) || (inches > 12)) {
            return -1;
        }
        double totalInches = feet * 12 + inches;
        return totalInches * 2.54;
    }

    public static double calcFeetAndInchesToCentimeters(double inches) {
        if (inches < 0) {
            return -1;
        }
        return calcFeetAndInchesToCentimeters((int) inches / 12, inches % 12);
    }



}
