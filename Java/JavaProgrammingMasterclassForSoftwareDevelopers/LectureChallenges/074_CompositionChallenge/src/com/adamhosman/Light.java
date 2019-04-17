package com.adamhosman;

public class Light {

    private boolean isOn;
    private int lumens;

    public Light(int lumens) {
        this.isOn = false;
        this.lumens = lumens;
    }

    public void turnOn() {
        this.isOn = true;
        System.out.println("Lights have been turned on and shining with the power of " + lumens + " lumens.");
    }

    public void turnOff() {
        this.isOn = false;
        System.out.println("Lights have been turned off.");
    }

}
