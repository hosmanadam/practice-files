package com.adamhosman;

public class GreatestCommonDivisor {

    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor(1200, 450));
    }

    public static int getGreatestCommonDivisor(int first, int second) {
        if ((first < 10) || (second < 10))
            return -1;
        int greatestCommonDivisor = 1;
        int candidate = 2;
        while (candidate <= Math.min(first, second)) {
            if ((first % candidate == 0) && (second % candidate == 0)) {
                greatestCommonDivisor = candidate;
            }
            candidate++;
        }
        return greatestCommonDivisor;
    }

}
