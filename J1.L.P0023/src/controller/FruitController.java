/*
 * Copyright(C) 2022, Nguyen The Minh.
 * Code: J1.L.P0023 (175 LOC)
 * Title: Fruit Shop
 */
package controller;

import java.util.ArrayList;
import model.Fruit;

/**
 * This class is used to manage fruit.
 *
 * @author Nguyen The Minh
 */
public class FruitController {
    
    private final ArrayList<Fruit> fruitsList = new ArrayList<>(); // List contain fruit in shop

    /**
     * This method is used to add sample data to fruits list.
     */
    public void addSampleData() {
        addFruit("1", "Coconut", 20, "VietNam", 3.5f);
        addFruit("2", "Apple", 10, "VietNam", 2.5f);
        addFruit("3", "Banana", 15, "VietNam", 4.5f);
        addFruit("4", "Orange", 20, "VietNam", 3.5f);
        addFruit("5", "Watermelon", 30, "VietNam", 5.5f);
    }

    /**
     * This method is used to add fruit to shop.
     */
    public boolean addFruit(String fruitId, String fruitname, int quantity, String origin, float price) {
        Fruit fruit = new Fruit();
        fruit.setFruitId(fruitId);
        fruit.setName(fruitname);
        fruit.setQuantity(quantity);
        fruit.setOrigin(origin);
        fruit.setPrice(price);
        return fruitsList.add(fruit);
    }

    /**
     * This method is used to get list of fruit in shop.
     */
    public ArrayList<Fruit> getFruitsList() {
        return fruitsList;
    }

    /**
     * This method is used to get fruit by id.
     *
     * @param fruitId - id of fruit
     */
    public Fruit getFruitById(String id) {
        for (Fruit fruit : fruitsList) {
            if (fruit.getFruitId().equals(id)) {
                return fruit;
            }
        }
        return null;
    }
}
