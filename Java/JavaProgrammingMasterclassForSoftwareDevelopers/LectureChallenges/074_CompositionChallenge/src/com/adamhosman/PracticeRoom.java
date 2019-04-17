package com.adamhosman;

public class PracticeRoom {

    private Light light;
    private Piano piano;
    private Stool stool;

    public PracticeRoom() {
        this.light = new Light(1001);
        this.piano = new Piano(88);
        this.stool = new Stool(50, 100, 0.5);
    }

    public Piano getPiano() {
        return piano;
    }

    public void setUp() {
        light.turnOn();
        piano.tune();
        stool.raise(20);
    }

    public void tearDown() {
        light.turnOff();
        piano.deTune();
        stool.lower(1000);
    }

}
