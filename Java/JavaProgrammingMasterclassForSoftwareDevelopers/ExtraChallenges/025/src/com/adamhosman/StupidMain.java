package com.adamhosman;

public class StupidMain {

    public static void main(String[] args) {
        System.out.println(getLargestPrime(217));
    }

//    public static int getLargestPrime(int number) {
//        if (number < 2)
//            return -1;
//
//        int largestPrime = 2;
//        outer: for (int candidate = 3; candidate <= number; candidate += 2) {
//            if (number % candidate == 0) {
//                inner: for (int divisor = 2; divisor <= candidate / 2; divisor++) {
//                    if (candidate % divisor == 0)
//                        continue outer;
//                }
//                largestPrime = candidate;
//            }
//        }
//        return largestPrime;
//    }

    public static int getLargestPrime(int number) {
        if (number < 2)
            return -1;

        outer: for (int candidate = number; candidate > 1; candidate--) {
            if (number % candidate == 0) {
                for (int divisor = 2; divisor <= candidate / 2; divisor++) {
                    if (candidate % divisor == 0)
                        continue outer;
                }
                return candidate;
            }
        }

        return -1;
    }

}
