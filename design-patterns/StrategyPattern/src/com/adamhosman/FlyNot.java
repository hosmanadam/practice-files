package com.adamhosman;

public class FlyNot implements FlyStrategy {

    @Override
    public void fly(String name) {
        System.out.println(name + " can't fly.");
    }
}
