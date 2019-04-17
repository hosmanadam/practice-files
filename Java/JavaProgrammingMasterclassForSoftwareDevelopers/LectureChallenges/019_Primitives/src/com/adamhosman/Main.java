package com.adamhosman;

public class Main {

    public static void main(String[] args) {
        // WHOLE NUMBERS
        byte maxByte = 127;  // 2**8/2-1
        short maxShort = 32_767;  // 2**16/2-1
        int maxInt = 2_147_483_647;  // 2**32/2-1
        long maxLong = 9_223_372_036_854_775_807L;  // 2**64/2-1
        System.out.println(maxLong);

        // CASTING
        byte castByte = (byte) (maxByte/2);  // Cast int result to byte explicitly
        long someAddition = 50000 + 10 * (maxByte + maxShort + maxInt);  // Cast int result to long implicitly
        System.out.println(castByte);
        System.out.println(someAddition);

        // DECIMALS
        int pounds = 100;
        double kilograms = pounds * 0.45359237;
        System.out.println(kilograms);

        // CHAR
        char charFromCode = '\u00A9';
        char charFromChar = '©';
        System.out.println(charFromCode == charFromChar);
        System.out.println(charFromCode);

        // BOOLEAN
        boolean myBoolean = true;
        System.out.println(myBoolean);

        // STRING
        String myString = "Hey, I'm a string!!!";
        System.out.println(myString);
        System.out.println(myString + " And this is a byte implicitly cast: " + maxByte);
    }
}
