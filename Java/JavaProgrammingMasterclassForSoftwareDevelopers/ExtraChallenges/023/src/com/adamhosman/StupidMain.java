package com.adamhosman;

public class StupidMain {

    public static void main(String[] args) {
        numberToWords(123);
    }

    public static void numberToWords(int number) {
        if (number < 0) {
            System.out.println("Invalid Value");
        } else {
            int reversedNumber = reverse(number);
            int digitCount = getDigitCount(number);
            int reverseDigitCount = getDigitCount(reversedNumber);
            int leadingZeroCount = digitCount - reverseDigitCount;

            do {
                String numString = "";
                switch (reversedNumber % 10) {
                    case 0: numString = "Zero"; break;
                    case 1: numString = "One"; break;
                    case 2: numString = "Two"; break;
                    case 3: numString = "Three"; break;
                    case 4: numString = "Four"; break;
                    case 5: numString = "Five"; break;
                    case 6: numString = "Six"; break;
                    case 7: numString = "Seven"; break;
                    case 8: numString = "Eight"; break;
                    case 9: numString = "Nine"; break;
                }
                System.out.println(numString);
                reversedNumber /= 10;
            } while (reversedNumber > 0);

            for (int i=0; i<leadingZeroCount; i++) {
                System.out.println("Zero");
            }
        }
    }

    public static int reverse(int number) {
        int reversedCollector = 0;
        while (true) {
            reversedCollector += number % 10;
            number /= 10;
            if (number == 0)
                return reversedCollector;
            reversedCollector *= 10;
        }
    }

    public static int getDigitCount(int number) {
        if (number < 0)
            return -1;

        int digitCount = 0;
        do {
            digitCount++;
            number /= 10;
        } while (number > 0);
        return digitCount;
    }

}
