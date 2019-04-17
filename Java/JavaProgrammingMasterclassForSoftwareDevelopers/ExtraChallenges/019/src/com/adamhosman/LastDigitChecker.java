package com.adamhosman;

public class LastDigitChecker {

    public static void main(String[] args) {
        System.out.println(hasSameLastDigit(123, 234, 345));
        System.out.println(hasSameLastDigit(113, 223, 333));
    }

    public static boolean hasSameLastDigit(int x, int y, int z) {
        int[] nums = {x, y, z};
        for (int num : nums) {
            if (!isValid(num))
                return false;
        }
        int xLast = x % 10;
        int yLast = y % 10;
        int zLast = z % 10;
        return ((xLast == yLast) || (xLast == zLast) || (yLast == zLast));
    }

    public static boolean isValid(int num) {
        return ((num > 9) && (num < 1001));
    }

}
