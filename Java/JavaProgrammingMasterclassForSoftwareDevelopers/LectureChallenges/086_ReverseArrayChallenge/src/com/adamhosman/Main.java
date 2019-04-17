package com.adamhosman;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] intArray = getIntRangeArray(10);
        reverse(intArray);
        System.out.println(Arrays.toString(intArray));
        }

    public static int[] getIntRangeArray(int length) {
        int[] intArray = new int[length];
        for (int i=0; i<length; i++) {
            intArray[i] = i+1;
        }
        return intArray;
    }

    public static void reverse(int[] intArray) {
        int temp;
        for (int i=0; i<intArray.length/2; i++) {
            temp = intArray[i];
            intArray[i] = intArray[intArray.length - i - 1];
            intArray[intArray.length - i - 1] = temp;
        }
    }

}
