package com.adamhosman;

class Car {

    private boolean electric;
    private boolean isEngineOn;
    private int horsePower;
    private int cylinders;
    private int wheels;
    private String color;
    private int maxKmPerHour;
    private int currentKmPerHour;

    public Car(boolean electric, int horsePower, int cylinders, String color, int maxKmPerHour) {
        this.electric = electric;
        this.isEngineOn = false;
        this.horsePower = horsePower;
        this.cylinders = cylinders;
        this.wheels = 4;
        this.color = color;
        this.maxKmPerHour = maxKmPerHour;
        this.currentKmPerHour = 0;
    }

    public boolean isElectric() {
        return electric;
    }

    public boolean isEngineOn() {
        return isEngineOn;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getWheels() {
        return wheels;
    }

    public String getColor() {
        return color;
    }

    public int getMaxKmPerHour() {
        return maxKmPerHour;
    }

    public int getCurrentKmPerHour() {
        return currentKmPerHour;
    }

    public void start() {
        isEngineOn = true;
        System.out.println(getClass().getSimpleName() + " engine running.");
    }

    public void stop() {
        if (this.currentKmPerHour > 0) {
            decreaseSpeed(Integer.MAX_VALUE);
        }
        isEngineOn = false;
        System.out.println(getClass().getSimpleName() + " engine stopped.");
    }

    public void paint(String color) {
        String oldColor = this.color;
        this.color = color;
        System.out.println(getClass().getSimpleName() + " repainted from " + oldColor + " to " + color);
    }

    public void increaseSpeed(int kmPerHour) {
        if (!this.isEngineOn) {
            System.out.println(getClass().getSimpleName() + " can't start with the engine off");
        } else {
            int oldKmPerHour = currentKmPerHour;
            int requestedKmPerHour = currentKmPerHour += kmPerHour;
            if (requestedKmPerHour > this.maxKmPerHour) {
                currentKmPerHour = maxKmPerHour;
                System.out.println(getClass().getSimpleName() + " can't do " + requestedKmPerHour + "km/h");
            } else if (requestedKmPerHour < 0) {
                currentKmPerHour = 0;
            }
            if (requestedKmPerHour != oldKmPerHour) {
                System.out.println(getClass().getSimpleName() + " changed speed from " + oldKmPerHour + "km/h to " + currentKmPerHour + "km/h");
            }
        }
    }

    public void decreaseSpeed(int kmPerHour) {
        increaseSpeed(kmPerHour * -1);
    }

}

class Porsche extends Car {

    public Porsche(String color) {
        super(false, 5000, 6, color, 350);
    }

    @Override
    public void paint(String color) {
        if (color.toLowerCase().equals("red") || color.toLowerCase().equals("silver")) {
            super.paint(color);
        } else {
            System.out.println("Can't paint " + getClass().getSimpleName() + " to " + color + ". " + getClass().getSimpleName() + " can only be red or silver");
        }
    }
}

class Tesla extends Car {

    public Tesla(String color) {
        super( true, 4000, 4, color, 300);
    }
}

class Trabant extends Car {

    public Trabant(String color) {
        super(false, 80, 2, color, 80);
    }
}

public class Main {

    public static void main(String[] args) {

        Car generic = new Car(false, 100, 4, "black", 160);
        Car porsche = new Porsche("red");
        Car tesla = new Tesla("black");
        Car trabant = new Trabant("blue");

        generic.increaseSpeed(320);
        porsche.increaseSpeed(320);
        trabant.increaseSpeed(320);
        tesla.increaseSpeed(320);

        generic.start();
        porsche.start();
        tesla.start();
        trabant.start();

        generic.increaseSpeed(320);
        porsche.increaseSpeed(320);
        trabant.increaseSpeed(320);
        tesla.increaseSpeed(320);

        generic.stop();
        porsche.stop();
        tesla.stop();
        trabant.stop();

        generic.paint("zebra");
        porsche.paint("yellow");
        trabant.paint("purple");
        tesla.paint("white");

        generic.paint("tiger");
        porsche.paint("silver");
        trabant.paint("magenta");
        tesla.paint("red");

    }
}
