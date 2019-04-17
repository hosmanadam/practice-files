package com.adamhosman;

public class Main {

    public static void main(String[] args) {

        Burger burger;

        burger = new StandardBurger(new Lettuce(), new Tomato(), new Cheddar(), new Sauce());
        burger.printPrice();

        burger = new HealthyBurger(new Lettuce(), new Tomato());
        burger.printPrice();

        burger = new DeluxeBurger();
        burger.printPrice();

        burger = new AdamsBurger();
        burger.printPrice();

    }
}
