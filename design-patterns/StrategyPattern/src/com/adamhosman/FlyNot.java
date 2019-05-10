package com.adamhosman;

public class FlyNot implements FlyStrategy {

    @Override
    public void fly(Duck duck) {
        System.out.println(duck.getName() + " can't fly.");
    }
}
