package com.adamhosman;

public class QuackNot implements QuackStrategy {

    @Override
    public void quack(String name) {
        System.out.println(name + " can't quack.");
    }
}
