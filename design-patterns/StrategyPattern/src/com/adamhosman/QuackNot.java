package com.adamhosman;

public class QuackNot implements QuackStrategy {

    @Override
    public void quack(Duck duck) {
        System.out.println(duck.getName() + " can't quack.");
    }
}
