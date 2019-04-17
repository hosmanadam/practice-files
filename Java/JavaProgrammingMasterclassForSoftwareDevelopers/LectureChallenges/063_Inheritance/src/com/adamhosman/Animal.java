package com.adamhosman;

public class Animal {

    private String name;
    private int brain;
    private int body;
    private int size;
    private int weight;

    public Animal(String name, int brain, int body, int size, int weight) {
        this.name = name;
        this.brain = brain;
        this.body = body;
        this.size = size;
        this.weight = weight;
    }

    public void eat(String thing) {
        System.out.println("Animal is eating " + thing);
    }

    public void move (int speed) {
        System.out.println("Animal is moving at speed " + speed);
    }

}
