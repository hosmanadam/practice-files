package com.timbuchalka;

import java.util.Map;

/**
 * https://www.udemy.com/java-the-complete-java-developer-course/learn/lecture/4702382
 *
 * Modify the program so that adding items to the shopping basket doesn't
 * actually reduce the stock count but, instead, reserves the requested
 * number of items. ✓
 *
 * You will need to add a "reserved" field to the StockItem class to store the
 * number of items reserved. ✓
 *
 * Items can continue to be added to the basket, but it should not be possible to
 * reserve more than the available stock of any item. An item's available stock
 * is the stock count less the reserved amount. ✓
 *
 * The stock count for each item is reduced when a basket is checked out, at which
 * point all reserved items in the basket have their actual stock count reduced. ✓
 *
 * Once checkout is complete, the contents of the basket are cleared. ✓
 *
 * It should also be possible to "unreserve" items that were added to the basket
 * by mistake. ✓
 *
 * The program should prevent any attempt to unreserve more items than were
 * reserved for a basket. ✓
 *
 * Add code to Main that will unreserve items after they have been added to the basket,
 * as well as unreserving items that have not been added to make sure that the code
 * can cope with invalid requests like that.
 *
 * After checking out the baskets, display the full stock list and the contents of each
 * basket that you created.
 *
 * * * * *
 * TODO: Don't make any modifications other than the ones necessary to pass the 'test cases'
 */
public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
	    StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

//        for(String s: stockList.Items().keySet()) {
//            System.out.println(s);
//        }

        Basket timsBasket = new Basket("Tim");
        reserveItem(timsBasket, "car", 1);
//        System.out.println(timsBasket);

        reserveItem(timsBasket, "car", 1);
//        System.out.println(timsBasket);

        if(reserveItem(timsBasket, "car", 1) != 1) {
            System.out.println("There are no more cars in stock");
        }

        reserveItem(timsBasket, "spanner", 5);
//        System.out.println(timsBasket);

        reserveItem(timsBasket, "juice", 4);
        reserveItem(timsBasket, "cup", 12);
        reserveItem(timsBasket, "bread", 1);

        unReserveItem(timsBasket, "cup", 12);
        unReserveItem(timsBasket, "cup", 12);

        Basket adamsBasket = new Basket("Adam");
        reserveItem(adamsBasket, "car", 1);
        System.out.println(adamsBasket);

        System.out.println(timsBasket);
        timsBasket.checkout();
        System.out.println(timsBasket);
        System.out.println(stockList);

        //temp = new StockItem("pen", 1.12);
        //stockList.Items().put(temp.getName(), temp);
//        stockList.Items().get("car").adjustStock(2000);
//        stockList.get("car").adjustStock(-1000);
//        System.out.println(stockList);
//        for(Map.Entry<String, Double> price: stockList.PriceList().entrySet()) {
//            System.out.println(price.getKey() + " costs " + price.getValue());
//        }


    }

    public static int reserveItem(Basket basket, String item, int quantity) {
        //retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(stockList.reserveStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        } else {
            System.out.println("Can't add more " + item + " to basket");
        }
        return 0;
    }

    public static int unReserveItem(Basket basket, String item, int quantity) {
        //retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        boolean removingAll = (stockItem.getQuantityReserved() == quantity);
        if(stockList.unReserveStock(item, quantity) != 0) {
            basket.removeFromBasket(stockItem, quantity, removingAll);
            return quantity;
        } else {
            System.out.println("Can't remove more " + item + " from basket");
        }
        return 0;
    }
}
