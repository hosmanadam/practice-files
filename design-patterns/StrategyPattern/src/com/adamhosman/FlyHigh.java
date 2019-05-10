package com.adamhosman;

public class FlyHigh implements FlyStrategy {

    @Override
    public void fly(String name) {
        System.out.println(name + " is soaring high in the skies...");
    }
}
