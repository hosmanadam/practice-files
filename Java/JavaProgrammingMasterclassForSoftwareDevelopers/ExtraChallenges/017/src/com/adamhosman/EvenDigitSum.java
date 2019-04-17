package com.adamhosman;

public class EvenDigitSum {

    public static void main(String[] args) {
        System.out.println(getEvenDigitSum(2206));
    }

    public static int getEvenDigitSum(int number) {
        if (number < 0) {
            return -1;
        }
        int sum = 0;

        while (number > 0) {
            int nextDigit = number % 10;
            if (nextDigit % 2 == 0) {
                sum += nextDigit;
            }
            number /= 10;
        }
        return sum;
    }

}
