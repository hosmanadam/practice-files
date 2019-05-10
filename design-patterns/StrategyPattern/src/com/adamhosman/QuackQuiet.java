package com.adamhosman;

public class QuackQuiet implements QuackStrategy {

    @Override
    public void quack(String name) {
        System.out.println(name + ": \"quack\"");
    }
}
