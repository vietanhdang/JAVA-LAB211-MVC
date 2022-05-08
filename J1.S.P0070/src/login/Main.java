/*
 * Copyright(C) 2022, Nguyen The Minh.
 * Code: J1.S.P0070 (150 LOC)
 * Title: Login system of the Tien Phong Bank’s Ebank
 */
package login;

import java.util.Locale;

/**
 * This class is used to run the program.
 *
 * @author Nguyen The Minh
 */
public class Main {

    /**
     * This method is used to run the program.
     *
     * @param args is the arguments of the program.
     *
     */
    public static void main(String[] args) {
        Ebank ebank = new Ebank();
        Locale vietnamese = new Locale("vi"); // Vietnamese language
        Locale english = new Locale("en"); // English language
        System.out.println("=================LOGIN======================");
        System.out.println("1. English");
        System.out.println("2. Vietnamese");
        System.out.println("3. Exit");
        System.out.print("Please choose language: ");
        int choice = ebank.getNumberInRange(1, 3, english); // Get choice
        switch (choice) {
            case 1:
                ebank.setLocate(english);
                ebank.login(); // Login in English
                break;
            case 2:
                ebank.setLocate(vietnamese);
                ebank.login(); // Login in Vietnamese
                break;
            case 3:
                System.exit(0); // Exit
                break;
        }
    }
}
