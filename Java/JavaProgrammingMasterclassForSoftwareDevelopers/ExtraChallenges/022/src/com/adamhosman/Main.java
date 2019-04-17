package com.adamhosman;

public class Main {

    public static void main(String[] args) {
        System.out.println(isPerfectNumber(6));
    }

    public static boolean isPerfectNumber(int number) {
        if (number < 1) {
            return false;
        } else {
            int sumOfDivisors = 0;
            int nextDivisorCandidate = 1;
            while (nextDivisorCandidate <= number/2) {
                if (number % nextDivisorCandidate == 0)
                    sumOfDivisors += nextDivisorCandidate;
                nextDivisorCandidate++;
            }
            return (number == sumOfDivisors);
        }
    }

}
