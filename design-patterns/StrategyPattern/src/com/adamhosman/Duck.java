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

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public void quack() {
        quack.quack(this);
    }

    public void fly() {
        fly.fly(this);
    }

    public void display() {
        display.display(this);
    }

}
