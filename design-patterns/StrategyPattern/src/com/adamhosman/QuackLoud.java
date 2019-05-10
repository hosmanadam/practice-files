package com.adamhosman;

public class QuackLoud implements QuackStrategy {

    @Override
    public void quack(String name) {
        System.out.println(name + ": \"QUACK QUACK QUACK QUACK QUACK QUACK\"");
    }
}
