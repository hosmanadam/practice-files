package com.adamhosman;

public class Burger {

    private double basePrice;
    private Ingredient meat;
    private Ingredient roll;
    private Ingredient addition1;
    private Ingredient addition2;
    private Ingredient addition3;
    private Ingredient addition4;

    public Burger(Roll roll, Ingredient addition1, Ingredient addition2, Ingredient addition3, Ingredient addition4) {
        this.basePrice = 0.99;
        this.meat = new Meat();
        this.roll = roll;
        this.addition1 = addition1;
        this.addition2 = addition2;
        this.addition3 = addition3;
        this.addition4 = addition4;
    }

    public String formatDollars(double amount) {
        return String.format("$%.2f", amount);
    }

    public double getTotalPrice() {
        double totalPrice = basePrice;
        Ingredient[] ingredients = {meat, roll, addition1, addition2, addition3, addition4};
        for (Ingredient ingredient : ingredients) {
            if (ingredient != null) {
                totalPrice += ingredient.getPrice();
            }
        }
        return totalPrice;
    }

    public void printPrice() {
        System.out.println("Your " + getClass().getSimpleName() + " costs:");
        System.out.println("  - Base price: " + formatDollars(basePrice));
        Ingredient[] ingredients = {meat, roll, addition1, addition2, addition3, addition4};
        for (Ingredient ingredient : ingredients) {
            if (ingredient != null) {
                System.out.println("  - " + ingredient.getName() + ": " + formatDollars(ingredient.getPrice()));
            }
        }
        System.out.println("  - TOTAL: " + formatDollars(getTotalPrice()));
        System.out.println();
    }

}

class StandardBurger extends Burger {

    public StandardBurger(Ingredient addition1, Ingredient addition2, Ingredient addition3, Ingredient addition4) {
        super(new WhiteRoll(), addition1, addition2, addition3, addition4);
    }

}

class HealthyBurger extends Burger {

    public HealthyBurger(Ingredient addition1, Ingredient addition2) {
        super(new RyeRoll(), addition1, addition2, null, null);
    }

}

class DeluxeBurger extends Burger {

    public DeluxeBurger() {
        super(new WhiteRoll(), new Fries(), new Soda(), null, null);
    }

}

class AdamsBurger extends StandardBurger {

    public AdamsBurger() {
        super(new Lettuce(), new Jalapeno(), new Cheddar(), new Sauce());
    }

}
