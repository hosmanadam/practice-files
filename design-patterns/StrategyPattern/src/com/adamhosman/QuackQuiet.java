package com.adamhosman;

public class QuackQuiet implements QuackStrategy {

    @Override
    public void quack(Duck duck) {
        System.out.println(duck.getName() + ": \"quack\"");
    }
}
