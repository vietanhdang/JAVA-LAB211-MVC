/*
 * Copyright(C) 2022, Nguyen The Minh.
 * Code: J1.L.P0023 (175 LOC)
 * Title: Fruit Shop
 */
package controller;

import java.util.ArrayList;

import model.Fruit;

/**
 * This class is used to process cart.
 *
 * @author Nguyen The Minh
 */
public class CartController {
    public final ArrayList<Fruit> cart = new ArrayList<>(); // List contain fruit in cart

    /**
     * This method is used to add fruit to cart.
     * 
     * @param cart     - cart of customer
     * @param fruitId  - id of fruit
     * @param quantity - quantity of fruit
     */
    public void addFruitToCart(Fruit fruit, int quantity) {
        if (cart.contains(fruit)) { // if fruit is already in cart
            Fruit currentFruit = cart.get(cart.indexOf(fruit)); // get fruit in cart
            currentFruit.setQuantity(currentFruit.getQuantity() + quantity); // add quantity to fruit
            fruit.setQuantity(fruit.getQuantity() - quantity); // reduce quantity of fruit
        } else { // if fruit is not in cart
            cart.add(new Fruit(fruit.getFruitId(), fruit.getName(), quantity, fruit.getOrigin(), fruit.getPrice())); // add
                                                                                                                     // fruit
                                                                                                                     // to
                                                                                                                     // cart
            fruit.setQuantity(fruit.getQuantity() - quantity); // reduce quantity of fruit
        }
    }

    /**
     * This method is used to get cart.
     * 
     * @return cart
     */
    public ArrayList<Fruit> getCart() {
        return cart;
    }
}
