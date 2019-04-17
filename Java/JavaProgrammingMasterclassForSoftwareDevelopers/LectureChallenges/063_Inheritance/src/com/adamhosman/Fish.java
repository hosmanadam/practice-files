package com.adamhosman;

public class Fish extends Animal {

    private int gills;
    private int eyes;
    private int fins;

    public Fish(String name, int size, int weight, int gills, int eyes, int fins) {
        super(name, 1, 1, size, weight);
        this.gills = gills;
        this.eyes = eyes;
        this.fins = fins;
    }

    public void rest() {

    }

    public void swim() {
        moveMuscles();
        moveBackFin();
        move(10);
    }

    private void moveMuscles() {
        System.out.println("Fish is moving muscles");
    }

    private void moveBackFin() {
        System.out.println("Fish is moving back fin");
    }

}
