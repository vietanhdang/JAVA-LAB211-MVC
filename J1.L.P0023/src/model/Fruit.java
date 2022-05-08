/*
 * Copyright(C) 2022, Nguyen The Minh.
 * Code: J1.L.P0023 (175 LOC)
 * Title: Fruit Shop
 */
package model;

/**
 * This class is definition of fruit object.
 *
 * @author Nguyen The Minh
 */
public class Fruit {

    private String fruitId; // Fruit identification
    private String name; // Name of fruit
    private int quantity; // Quantity of fruit
    private String origin; // Origin of fruit
    private float price; // Price of fruit

    /**
     * This is constructor with out parameter.
     */
    public Fruit() {
    }

    /**
     * Constructs a new Fruit whose information are specified by the parameter.
     *
     * @param fruitId - Id of fruit.
     * @param name - name of fruit.
     * @param quantity - quantity of fruit.
     * @param origin - origin of fruit.
     * @param price - price of fruit.
     */
    public Fruit(String fruitId, String name, int quantity, String origin, float price) {
        this.fruitId = fruitId;
        this.name = name;
        this.quantity = quantity;
        this.origin = origin;
        this.price = price;
    }

    /**
     * This method get fruitId of fruit and return it.
     *
     * @return id of fruit
     */
    public String getFruitId() {
        return fruitId;
    }

    /**
     * This method is set fruitId of fruit.
     *
     * @param fruitId - id of fruit.
     */
    public void setFruitId(String fruitId) {
        if (fruitId.isEmpty()) {
            throw new IllegalArgumentException("Fruit id is not empty!");
        }
        this.fruitId = fruitId;
    }

    /**
     * This method get fruit name and return it.
     *
     * @return String that is fruit name.
     */
    public String getName() {
        return name;
    }

    /**
     * This method is set fruit name.
     *
     * @param name - name of fruit.
     */
    public void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name is not valid");
        }
        this.name = name;
    }

    /**
     * This method get fruit origin and return it.
     *
     * @return String that is fruit origin.
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * This method is set fruit origin.
     *
     * @param origin - origin of fruit.
     */
    public void setOrigin(String origin) {
        if (origin.isEmpty()) {
            throw new IllegalArgumentException("Origin is not valid");
        }
        this.origin = origin;
    }

    /**
     * This method get fruit price and return it.
     *
     * @return real number that is fruit price.
     */
    public float getPrice() {
        return price;
    }

    /**
     * This method use to set fruit price.
     *
     * @param price price want to set
     */
    public void setPrice(float price) {
        if (price < 0) {
            throw new IllegalArgumentException("Invalid price");
        }
        this.price = price;
    }

    /**
     * This method get fruit quantity and return it.
     *
     * @return an integer number that is fruit quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * This method use to set fruit quantity.
     *
     * @param quantity quantity want to set
     */
    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Invalid quantity");
        }
        this.quantity = quantity;
    }

    /**
     * This method use to define hashCode of fruit and return it.
     *
     * @return hashCode of fruit
     */
    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    /**
     * This method compare two fruit object.
     *
     * @param obj object want to compare
     * @return true if two object are equal, false if not
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fruit other = (Fruit) obj;
        return !(this.fruitId == null ? other.fruitId != null : !this.fruitId.equals(other.fruitId));
    }

    /**
     * This method print out information of fruit.
     */
    public void displayFruit() {
        System.out.println(
                String.format("| %-9s| %-17s| %-13d| %-15s| $%-13.2f|", fruitId, name, quantity, origin, price));
    }
}
