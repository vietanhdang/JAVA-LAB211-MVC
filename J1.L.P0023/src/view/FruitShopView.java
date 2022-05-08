/*
 * Copyright(C) 2022, Nguyen The Minh.
 * Code: J1.L.P0023 (175 LOC)
 * Title: Fruit Shop
 */
package view;

import controller.CartController;
import controller.OrderController;
import controller.FruitController;
import java.util.ArrayList;
import model.Customer;
import model.Fruit;
import utility.InputReader;

/**
 * This class is used to view and run program.
 *
 * @author Nguyen The Minh
 */
public class FruitShopView {
    
    public final FruitController shopController = new FruitController(); // shop controller
    public final OrderController orderController = new OrderController(); // order controller
    public final InputReader inputReader = new InputReader(); // input reader

    /**
     * This method displayMainScreen all fruit that exist in shop and fruit
     * information.
     */
    private void displayFruits() {
        if (shopController.getFruitsList().isEmpty()) { // if list of fruit is empty
            System.out.println("There are no fruits in the shop!");
            return;
        }
        System.out.println("-------------------------LIST OF FRUITS-------------------------");
        System.out.printf("|%-10s|%-18s|%-14s|%-16s|%-15s|\n", "++ Item ++", " ++ Fruit Name ++ ", " + Quantity + ",
                " ++ Origin ++ ", " ++ Price ++ ");
        shopController.getFruitsList().forEach((fruit) -> {
            fruit.displayFruit();
        });
    }

    /**
     * This method allow owner can create new fruit in shop.
     */
    private void createFruit() {
        FruitController fruitController = new FruitController();
        System.out.println("=========CREATE FRUIT=========");
        while (true) {
            displayFruits(); // display all fruit in shop
            String fruitId = inputReader.getInputString("Enter fruit id: "); // get fruit id
            Fruit fruit = fruitController.getFruitById(fruitId); // get fruit
            if (fruit != null) { // if fruit is already exist
                fruit.setQuantity(fruit.getQuantity() + inputReader.getInputInteger("Enter quantity: ", 1)); // add
                // quantity
                System.out.println("Fruit added successfully.");
                displayFruits();
                if (!inputReader.getInputYesOrNo()) {
                    return;
                }
            } else {
                String fruitName = inputReader.getInputString("Enter fruit name: "); // get fruit name
                int quantity = inputReader.getInputInteger("Enter fruit quantity: ", 1); // get fruit quantity
                String origin = inputReader.getInputString("Enter fruit origin: "); // get fruit origin
                float price = inputReader.getInputFloat("Enter fruit price: ", 0); // get fruit price
                fruitController.addFruit(fruitId, fruitName, quantity, origin, price); // add fruit to shop
                System.out.println("Fruit added successfully.");
                displayFruits();
                if (!inputReader.getInputYesOrNo()) {
                    return;
                }
            }
        }
    }

    /**
     * This method displayMainScreen all order that buyer add and total money of
     * products. If don't have order return to main screen.
     */
    private void viewOrders() {
        System.out.println("=========VIEW ORDERS=========");
        if (orderController.getCustomerOrder().isEmpty()) {
            System.out.println("No orders found");
            return;
        }
        // get key and value of hashtable
        orderController.getCustomerOrder().forEach((customer, listFruits) -> {
            System.out.println("Customer: " + customer.getName()); // print customer
            displayListFruitOrder(listFruits); // print list of order
        });
    }

    /**
     * This method display all order that exist in order list. Then print out
     * total amount all order worth.
     *
     * @param listFruits - array list contain orders.
     */
    private void displayListFruitOrder(ArrayList<Fruit> listFruits) {
        float total = 0; // total money of all order
        System.out.println(String.format("| %-9s| %-14s| %-15s| %-12s| %-13s|", "ID", "Product", "Quantity",
                "Price", "Amount"));
        for (Fruit order : listFruits) {
            System.out.printf("| %-9s| %-14s| %-15d| $%-11.2f| $%-12.2f|\n", order.getFruitId(), order.getName(),
                    order.getQuantity(),
                    order.getPrice(), order.getQuantity() * order.getPrice());
            total += order.getQuantity() * order.getPrice();
        }
        System.out.println("Total: $" + String.format("%.2f", total));
        System.out.println("----------------------");
    }

    /**
     * This method allow buyer add product to their cart.
     */
    private void shopping() {
        if (shopController.getFruitsList().isEmpty()) { // If shop don't have any fruit.
            System.out.println("There are no fruits in the shop!");
            return;
        }
        CartController cartController = new CartController(); // cart controller
        while (true) {
            displayFruits(); // Display all fruit in shop.
            String fruitId = inputReader.getInputString("Enter fruit id: "); // get fruit id
            Fruit fruit = shopController.getFruitById(fruitId); // Get fruit object by id
            if (fruit == null) { // If fruit not exist.
                System.out.println("Fruit not found!");
                continue;
            }
            int quantityOfFruit = shopController.getFruitById(fruitId).getQuantity(); // Get quantity of fruit by ID.
            if (quantityOfFruit == 0) { // If quantity of fruit is 0.
                System.out.println("There are no other in shop");
                if (!inputReader.getInputYesOrNo()) {
                    break;
                }
                continue;
            }
            int quantityAdd = inputReader.getInputNumberInRange("Enter quantity: ", 1, quantityOfFruit,
                    "Quantity must in [" + 1 + "," + quantityOfFruit + "]"); // Get quantity of fruit that buyer want to
            // add.
            cartController.addFruitToCart(fruit, quantityAdd); // Add fruit to cart.
            if (!inputReader.getInputYesOrNo()) { // If buyer don't want to continue shopping.
                break;
            }
        }
        if (cartController.getCart().isEmpty()) { // If cart is empty. (Buyer don't add any product to cart.)
            System.out.println("-----------------------------");
            System.out.println("CAN'T ORDER BECAUSE CART IS EMPTY!");
            System.out.println("-----------------------------");
        } else { // If cart is not empty. (Buyer add some product to cart.)
            System.out.println("------LIST OF FRUITS IN THE CART-----");
            displayListFruitOrder(cartController.getCart()); // Display list of fruit in cart.
            String buyerName = inputReader.getInputString("Enter name: "); // Get name of buyer.
            orderController.createOrder(new Customer(buyerName), cartController.getCart()); // Create order.
            System.out.println("-----------------------------");
            System.out.println("Add order successfull");
            System.out.println("-----------------------------");
        }
    }

    /**
     * This method display main screen and get user input option and call method
     * according user input.
     */
    private void displayMainScreen() {
        shopController.addSampleData(); // Add sample data to shop.
        while (true) {
            System.out.println("=========FRUIT SHOP SYSTEM=========");
            System.out.println("1. Create Fruit");
            System.out.println("2. View orders");
            System.out.println("3. Shopping (for buyer)");
            System.out.println("4. Exit");
            int option = inputReader.getInputNumberInRange("Enter choice: ", 0, 4, "Choice must in [0-4]");
            switch (option) {
                case 1:
                    createFruit(); // create fruit
                    break;
                case 2:
                    viewOrders(); // view order
                    break;
                case 3:
                    shopping(); // shopping
                    break;
                case 4:
                    return; // exit
            }
        }
    }

    /**
     * This method is used to run program.
     *
     * @param args
     */
    public static void main(String[] args) {
        FruitShopView fruitShopView = new FruitShopView(); // create object of FruitShopView
        fruitShopView.displayMainScreen(); // display main screen
    }
}
