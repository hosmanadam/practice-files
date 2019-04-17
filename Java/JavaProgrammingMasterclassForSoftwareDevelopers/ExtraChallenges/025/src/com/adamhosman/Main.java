package com.adamhosman;

public class Main {

    public static void main(String[] args) {
        System.out.println(getLargestPrime(217));
    }

    public static int getLargestPrime(int number) {
        if (number < 4)
            return -1;

        int largestPrime = 2;
        for (int candidate = 3; candidate <= number / 2; candidate += 2) {
            if (isPrime(candidate) && isDivisorOf(candidate, number))
                largestPrime = candidate;
        }
        return largestPrime;
    }

    public static boolean isPrime(int number) {
        if (number < 2)
            return false;
        for (int divisor = 2; divisor <= number / 2; divisor++) {
            if (number % divisor == 0)
                return false;
        }
        return true;
    }

    public static boolean isDivisorOf(int divisor, int divisee) {
        return (divisee % divisor == 0);
    }

}
