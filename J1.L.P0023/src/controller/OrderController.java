/*
 * Copyright(C) 2022, Nguyen The Minh.
 * Code: J1.L.P0023 (175 LOC)
 * Title: Fruit Shop
 */
package controller;

import java.util.ArrayList;
import java.util.Hashtable;
import model.Customer;
import model.Fruit;

/**
 * This class is used to process order.
 *
 * @author Nguyen The Minh
 */
public class OrderController {

    private final Hashtable<Customer, ArrayList<Fruit>> customerOrder = new Hashtable<>(); // Hashtable contain customer and list of fruit order

    /**
     * This method is used to get customer order.
     *
     * @return customerOrder
     *
     */
    public Hashtable<Customer, ArrayList<Fruit>> getCustomerOrder() {
        return customerOrder;
    }

    /**
     * This method is used to create order.
     *
     * @param customer - name of customer
     * @param cart - cart of customer
     *
     */
    public void createOrder(Customer customer, ArrayList<Fruit> cart) {
        if (customer == null || cart.isEmpty()) {
            throw new IllegalArgumentException("Customer or cart is not valid");
        }
        customerOrder.put(customer, cart);
    }
}
