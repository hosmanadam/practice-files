package com.timbuchalka;

/**
 * Created by dev on 16/02/2016.
 */
public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityInStock = 0;
    private int quantityReserved;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityInStock = 0;  // or here (but you wouldn't normally do both).
        this.quantityReserved = 0;
    }

    public StockItem(String name, double price, int quantityInStock) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.quantityReserved = 0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public int getQuantityReserved() {
        return quantityReserved;
    }

    public int getQuantityAvailable() {
        return quantityInStock - quantityReserved;
    }

    public void setPrice(double price) {
        if(price > 0.0) {
            this.price = price;
        }
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityInStock + quantity;
        if(newQuantity >=0) {
            this.quantityInStock = newQuantity;
        }
    }

    public boolean reserve(int quantity) {
        int available = quantityInStock - quantityReserved;
        if (quantity <= available) {
            this.quantityReserved += quantity;
            return true;
        }
        return false;
    }

    public boolean unReserve(int quantity) {
        if (quantity <= quantityReserved) {
            this.quantityReserved -= quantity;
            return true;
        }
        return false;
    }

    public boolean sellReserved(int quantity) {
        if (quantity <= quantityReserved) {
            quantityInStock -= quantity;
            quantityReserved -= quantity;
            return true;
        }
        return false;
    }

        @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals");
        if(obj == this) {
            return true;
        }

        if((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public int compareTo(StockItem o) {
//        System.out.println("Entering StockItem.compareTo");
        if(this == o) {
            return 0;
        }

        if(o != null) {
            return this.name.compareTo(o.getName());
        }

        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + " : price " + this.price;
    }
}
