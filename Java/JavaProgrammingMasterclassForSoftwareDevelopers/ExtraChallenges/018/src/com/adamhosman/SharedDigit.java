package com.adamhosman;

public class SharedDigit {

    public static void main(String[] args) {
        System.out.println(hasSharedDigit(12, 34));
        System.out.println(hasSharedDigit(12, 23));
    }

    public static boolean hasSharedDigit(int x, int y) {
        if ((x < 10) || (x > 99) || (y < 10) || (y > 99))  {
            return false;
        }

        do {
            int nextDigitX = x % 10;
            int yCopy = y;
            do {
                int nextDigitY = yCopy % 10;
                if (nextDigitX == nextDigitY)
                    return true;
                yCopy /= 10;
            } while (yCopy > 0);
            x /= 10;
        } while (x > 0);

        return false;
    }

}
