package com.adamhosman;

public class Main {

    public static void main(String[] args) {

    }

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if ((bigCount < 0) || (smallCount < 0) || (goal < 0))
            return false;
        int kilosInStock = bigCount * 5 + smallCount;
        return ((kilosInStock >= goal) && (smallCount >= goal % 5));
    }

}
