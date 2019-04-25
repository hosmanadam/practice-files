package com.adamhosman;

public class Reducer {

    /**
     * Return the sum of all natural numbers up to and including {@code n}.
     *
     * <p>
     *     For example, {@code getRangeSum(5);} will return {@code 15},
     *     the result of the mathematical operation {@code 5+4+3+2+1} .
     * </p>
     *
     * @param  n the inclusive maximum up to which natural numbers should be summed
     * @return the sum of all natural numbers up to and including {@code n}.
     */
    public static int getRangeSum(int n) {
        return (n == 1 ? 1 : Reducer.getRangeSum(n-1) + n);
    }

    /**
     * Return the product of all natural numbers up to and including {@code n}.
     *
     * <p>
     *     For example, {@code getFactorial(5);} will return {@code 120},
     *     the result of the mathematical operation {@code 5*4*3*2*1} .
     * </p>
     *
     * @param  n the inclusive maximum up to which natural numbers should be multiplied
     * @return the product of all natural numbers up to and including {@code n}.
     */
    public static int getFactorial(int n) {
        return (n == 1 ? 1 : Reducer.getFactorial(n-1) * n);
    }

    /**
     * Return the {@code n}th Fibonacci number
     *
     * <p>
     *     For example, {@code getFib(5);} will return {@code 3}
     *     which is the 5th number in the sequence {@code 0, 1, 1, 2, 3..} .
     * </p>
     *
     * @param n the 1-indexed ordinal number representing the requested Fibonacci number
     * @return the {@code n}th Fibonacci number
     */
    public static int getFib(int n) {
        return getFib(0, 1, n);
    }

    private static int getFib(int x, int y, int n) {
        return (n < 1) ? (-1) : (n == 1) ? (x) : getFib(y, x+y, n-1);
    }

}
