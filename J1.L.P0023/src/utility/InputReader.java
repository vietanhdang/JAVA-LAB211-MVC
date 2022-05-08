/*
 * Copyright(C) 2022, Nguyen The Minh.
 * Code: J1.L.P0023 (175 LOC)
 * Title: Fruit Shop
 */
package utility;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * This class is used to read input from console.
 * 
 * @author Nguyen The Minh
 */
public class InputReader {
    /**
     * declare a variable SCANNER to use InputReader from keyboard
     */
    private final static Scanner SCANNER = new Scanner(System.in);

    /**
     * declare a final variable LOGGER to use logging for {@code InputReader}
     * class
     */
    private static final Logger LOGGER = Logger.getLogger(InputReader.class.getName());

    /**
     * This method requires the user to enter a string into the keyboard (with a
     * specified length) and returns a string
     *
     * @param message notify user input
     * @param length  fixed length
     * @return string
     */
    public String getInputString(String message) {
        while (true) {
            System.out.print(message);
            String inputString = SCANNER.nextLine().trim(); // take user input
            if (inputString.length() > 0) {
                return inputString;
            }
            LOGGER.warning("Your input is invalid. Please try again!"); // if empty string, enter again
        }
    }

    /**
     * This method requires the user to enter from keyboard and returns an
     * integer value from minimum input number to maximum input number from the
     * key
     *
     * @param message notify user input
     * @param min     minimum input number
     * @param max     maximum input number
     * @param error   message error for input
     * @return integer in range [min, max]
     */
    public int getInputNumberInRange(String message, int min, int max, String error) {
        while (true) {
            System.out.print(message); // notify user input
            String inputNumber = SCANNER.nextLine().trim();
            try {
                int number = Integer.parseInt(inputNumber); // parse input to integer
                if (number >= min && number <= max) {
                    return number;
                } else {
                    LOGGER.warning(error); // if number is not in range, enter again
                }
            } catch (NumberFormatException e) {
                LOGGER.warning(error); // if input is not integer, enter again
            }
        }
    }

    /**
     * This method ask user for input an integer until it is a positive integer
     * and greater than or equal to minValue
     *
     * @param message  notify user input
     * @param minValue minimum input number
     * @return integer
     */
    public int getInputInteger(String message, int minValue) {
        while (true) {
            System.out.print(message);
            String inputNumber = SCANNER.nextLine().trim();
            try {
                int number = Integer.parseInt(inputNumber);
                if (number >= minValue) {
                    return number;
                } else {
                    LOGGER.warning("Number must be greater than or equal to " + minValue);
                }
            } catch (NumberFormatException e) {
                LOGGER.warning("Your must enter a number!");
            }
        }
    }

    /**
     * This method ask user for input a float number until it is a real number and
     * greater than or equal to minValue
     *
     * @param message  out to console.
     * @param minValue min value method can return.
     * @return a float number
     */
    public float getInputFloat(String message, int minValue) {
        while (true) {
            System.out.print(message);
            String inputNumber = SCANNER.nextLine().trim();
            try {
                float number = Float.parseFloat(inputNumber);
                if (number >= minValue) {
                    return number;
                } else {
                    LOGGER.warning("Number must be greater than or equal to " + minValue);
                }
            } catch (NumberFormatException e) {
                LOGGER.warning("Your must enter a number!");
            }
        }
    }

    /**
     * This method check Yes or No from keyboard
     *
     * @return boolean true if enter y and false if enter n
     */
    public boolean getInputYesOrNo() {
        while (true) {
            System.out.print("Do you want to continue? (y/n): ");
            String input = SCANNER.nextLine().trim();
            if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n")) {
                return input.equalsIgnoreCase("y");
            } else {
                LOGGER.warning("Your input is invalid. Please try again!");
            }
        }
    }
}
