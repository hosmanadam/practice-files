package com.adamhosman;

public class Piano {

    private int numberOfKeys;
    private boolean isTuned;

    public Piano(int numberOfKeys) {
        this.numberOfKeys = numberOfKeys;
        this.isTuned = false;
    }

    public int getNumberOfKeys() {
        return numberOfKeys;
    }

    public void tune() {
        this.isTuned = true;
        System.out.println("All " + numberOfKeys + " keys of your piano have been tuned.");
    }

    public void deTune() {
        this.isTuned = false;
        System.out.println("All " + numberOfKeys + " keys of your piano have been detuned. (Nothing better to do?)");
    }

    public void play(String piece, String composer) {
        System.out.println("Piano is playing '" + piece + "' by " + composer);
    }

}
