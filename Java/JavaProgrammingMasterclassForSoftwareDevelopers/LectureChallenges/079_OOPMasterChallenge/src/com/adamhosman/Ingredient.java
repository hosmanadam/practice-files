package com.adamhosman;

public class Ingredient {

    private String name;
    private double price;

    public Ingredient(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Roll extends Ingredient {

    public Roll(String name, double price) {
        super(name, price);
    }
}

class WhiteRoll extends Roll {

    public WhiteRoll() {
        super("White roll", 0.49);
    }
}

class RyeRoll extends Roll {

    public RyeRoll() {
        super("Rye roll", 0.49);
    }
}

class Meat extends Ingredient {

    public Meat() {
        super("Meat", 0.99);
    }
}

class Lettuce extends Ingredient {

    public Lettuce() {
        super("Lettuce", 0.24);
    }
}

class Tomato extends Ingredient {

    public Tomato() {
        super("Tomato", 0.24);
    }
}

class Cheddar extends Ingredient {

    public Cheddar() {
        super("Cheddar", 0.49);
    }
}

class Sauce extends Ingredient {

    public Sauce() {
        super("Sauce", 0.49);
    }
}

class Jalapeno extends Ingredient {

    public Jalapeno() {
        super("Jalapeño", 0.24);
    }
}

class Bacon extends Ingredient {

    public Bacon() {
        super("Bacon", 0.49);
    }
}

class Fries extends Ingredient {

    public Fries() {
        super("Fries", 0.99);
    }
}

class Soda extends Ingredient {

    public Soda() {
        super("Soda", 0.99);
    }
}
