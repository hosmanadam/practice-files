package com.adamhosman;

public class Duck {

    private String name;
    private int age;
    private Sex sex;
    private QuackStrategy quack;
    private FlyStrategy fly;
    private DisplayStrategy display;

    public Duck(String name, int age, Sex sex, QuackStrategy quack, FlyStrategy fly, DisplayStrategy display) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.quack = quack;
        this.fly = fly;
        this.display = display;
    }

    public void quack() {
        quack.quack(name);
    }

    public void fly() {
        fly.fly(name);
    }

    public void display() {
        display.display(name, sex, age);
    }

}
