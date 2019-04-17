package com.adamhosman;

public class Main {

    public static void main(String[] args) {
    	Animal animal = new Animal("Animal", 1, 1, 5, 5);
    	Dog dog = new Dog("Yorkie", 8, 20, 3, 4, 1, 20, "long silky");
    	dog.eat("Apple!");
    	dog.walk();
    	dog.run();
    	Fish fish = new Fish("Fishie", 2, 3, 4, 5, 6);
    	fish.swim();
    }

}
