package com.adamhosman;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(getBucketCount(5.0, 5.0, 1.0, 3));
        System.out.println(getBucketCount(5.0, 5.0, 1.0));
        System.out.println(getBucketCount(25.0, 1.0));
    }

    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets) {
        if ((width <= 0) || (height <= 0) || (areaPerBucket <= 0) || (extraBuckets < 0))
            return -1;
        double areaToCover = width * height;
        return (int) (Math.ceil(areaToCover / areaPerBucket) - extraBuckets);
    }

    public static int getBucketCount(double width, double height, double areaPerBucket) {
        return getBucketCount(width, height, areaPerBucket, 0);
    }

    public static int getBucketCount(double area, double areaPerBucket) {
        return getBucketCount(area, 1.0, areaPerBucket, 0);
    }

}
