package com.adamhosman;

public class QuackLoud implements QuackStrategy {

    @Override
    public void quack(Duck duck) {
        System.out.println(duck.getName() + ": \"QUACK QUACK QUACK QUACK QUACK QUACK\"");
    }
}
