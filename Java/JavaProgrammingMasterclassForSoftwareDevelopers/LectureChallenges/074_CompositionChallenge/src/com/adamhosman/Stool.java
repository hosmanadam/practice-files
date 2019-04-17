package com.adamhosman;

public class Stool {

    private double currentHeightInCentimeters;
    private double minHeightInCentimeters;
    private double maxHeightInCentimeters;
    private double centimetersPerRotation;

    public Stool(double minHeightInCentimeters, double maxHeightInCentimeters, double centimetersPerRotation) {
        this.currentHeightInCentimeters = minHeightInCentimeters;
        this.minHeightInCentimeters = minHeightInCentimeters;
        this.maxHeightInCentimeters = maxHeightInCentimeters;
        this.centimetersPerRotation = centimetersPerRotation;
    }

    public void raise(double rotations) {
        double oldHeightInCentimeters = currentHeightInCentimeters;
        double desiredHeightInCentimeters = currentHeightInCentimeters + rotations * centimetersPerRotation;
        if (desiredHeightInCentimeters < minHeightInCentimeters) {
            this.currentHeightInCentimeters = minHeightInCentimeters;
        } else if (desiredHeightInCentimeters > maxHeightInCentimeters) {
            this.currentHeightInCentimeters = maxHeightInCentimeters;
        } else {
            this.currentHeightInCentimeters = desiredHeightInCentimeters;
        }
        System.out.println("Stool has been set from " + oldHeightInCentimeters + "cm high to " + currentHeightInCentimeters + "cm high.");
    }

    public void lower(double rotations) {
        raise(rotations * -1);
    }

}
