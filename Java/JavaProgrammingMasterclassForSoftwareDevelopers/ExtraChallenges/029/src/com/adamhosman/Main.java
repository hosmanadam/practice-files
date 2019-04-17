package com.adamhosman;

public class Main {

    public static void main(String[] args) {
        SimpleCalculator calc = new SimpleCalculator();
        calc.setFirstNumber(1);
        calc.setSecondNumber(5);
        System.out.println(calc.getAdditionResult());
    }



}
