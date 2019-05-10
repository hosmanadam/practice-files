package com.adamhosman;

public class DisplayAsText implements DisplayStrategy {

    @Override
    public void display(Duck duck) {
        String sex = duck.getSex() == Sex.MALE ? "male" : "female";
        System.out.println(duck.getName() + " is a " + duck.getAge() + " year old " + sex + " duck.");
    }

}
