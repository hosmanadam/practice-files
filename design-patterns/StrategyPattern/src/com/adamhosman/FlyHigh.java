package com.adamhosman;

public class FlyHigh implements FlyStrategy {

    @Override
    public void fly(Duck duck) {
        System.out.println(duck.getName() + " is soaring high in the skies...");
    }
}
