package com.adamhosman;

/**
 * An approximate implementation of the example in the following video by Christopher Okhravi:
 * https://youtu.be/v9ejT8FO-7I
 *
 * We create 3 kinds of ducks.
 * Instead of subclassing Duck 3 ways and overriding different behavior methods
 * (leading to code duplication and/or an increasingly complex inheritance hierarchy with made-up intermediary classes),
 * we delegate behavior to strategy interfaces and compose different kinds of ducks at runtime.
 */
public class Main {

    public static void main(String[] args) {
        // These could actually be subclasses of Duck while also be composed of strategy implementations
    	Duck wildie = createWildDuck("Wildie", 2, Sex.FEMALE);
    	Duck mrCitizen = createCityDuck("Mr. Citizen", 4, Sex.MALE);
    	Duck rubbie = createRubberDuck("Rubbie", 1, Sex.MALE);

    	// This is a special one-off duck that doesn't have a dedicated function to create it,
        // but the ability to compose any combination of behaviors together makes it easy to create
    	Duck msDifferent = new Duck("Ms. Different", 3, Sex.FEMALE, new QuackLoud(), new FlyNot(), new DisplayAsText());

        System.out.println();
    	wildie.display();
    	mrCitizen.display();
    	rubbie.display();
    	msDifferent.display();

        System.out.println();
    	wildie.quack();
    	mrCitizen.quack();
    	rubbie.quack();
    	msDifferent.quack();

        System.out.println();
    	wildie.fly();
    	mrCitizen.fly();
    	rubbie.fly();
    	msDifferent.fly();
    }

    static Duck createWildDuck(String name, int age, Sex sex) {
        return new Duck(name, age, sex, new QuackLoud(), new FlyHigh(), new DisplayAsText());
    }

    static Duck createCityDuck(String name, int age, Sex sex) {
        return new Duck(name, age, sex, new QuackQuiet(), new FlyHigh(), new DisplayAsText());
    }

    static Duck createRubberDuck(String name, int age, Sex sex) {
        return new Duck(name, age, sex, new QuackNot(), new FlyNot(), new DisplayAsText());
    }

}
