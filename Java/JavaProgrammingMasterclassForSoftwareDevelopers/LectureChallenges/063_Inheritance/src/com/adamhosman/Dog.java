package com.adamhosman;

public class Dog extends Animal {

    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;

    public Dog(String name, int size, int weight, int eyes, int legs, int tail, int teeth, String coat) {
        super(name, 1, 1, size, weight);
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
    }

    public void bark() {
        System.out.println("Bark bark!");
    }

    public void walk() {
        System.out.println("Dog walking!");
        move(5);
    }

    public void run() {
        System.out.println("Dog running!");
        move(15);
    }

    @Override
    public void eat(String thing) {
        bark();
        super.eat(thing);
    }

}
