package com.adamhosman;

public class DisplayAsText implements DisplayStrategy {

    @Override
    public void display(String name, Sex sex, int age) {
        String sexString = sex == Sex.MALE ? "male" : "female";
        System.out.println(name + " is a " + age + " year old " + sexString + " duck.");
    }

}
