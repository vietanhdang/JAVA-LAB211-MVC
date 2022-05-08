/*
 * Copyright(C) 2022, Nguyen The Minh.
 * Code: J1.L.P0023 (175 LOC)
 * Title: Fruit Shop
 */
package model;

/**
 * This class is definition of customer
 *
 * @author Nguyen The Minh
 */
public class Customer {

    private String name;

    /**
     * This is default constructor
     */
    public Customer() {
    }

    /**
     * This is constructor with parameter
     *
     * @param name name of customer
     */
    public Customer(String name) {
        this.name = name;
    }

    /**
     * This method is used get name of customer
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This method is used for set name of customer
     */
    public void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("name is not empty");
        }
        this.name = name;
    }

}
