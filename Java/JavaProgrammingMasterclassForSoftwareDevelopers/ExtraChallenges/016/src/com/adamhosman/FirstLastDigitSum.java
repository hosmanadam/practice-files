package com.adamhosman;

public class FirstLastDigitSum {

    public static void main(String[] args) {
        System.out.println(sumFirstAndLastDigit(105));
    }

    public static int sumFirstAndLastDigit(int number) {
        if (number < 0) {
            return -1;
        }
        int lastDigit = number % 10;
        int firstDigit = number;
        while (firstDigit > 9) {
            firstDigit /= 10;
        }
        return firstDigit + lastDigit;
    }

}
