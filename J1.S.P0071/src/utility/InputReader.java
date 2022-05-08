/*
 * Copyright(C) 2022, Nguyen The Minh.
 * Code: J1.S.P0071 (150 LOC)
 * Title: Task management program of CCRM project.
 */
package utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class contain method to read input from the user.
 *
 * @author Nguyen The Minh
 */
public class InputReader {

    /**
     * declare a scanner object to read input from the user.
     */
    private final Scanner SCANNER = new Scanner(System.in);
    /**
     * declare a validator object to check validator.
     */
    private final Validator validator = new Validator();
    /**
     * declare a logger object to log the error.
     */
    private static final Logger LOGGER = Logger.getLogger(InputReader.class.getName());

    /**
     * This method is used to read an integer from the user and return number in
     * the range [min, max].
     *
     * @param min min number
     * @param max max number
     * @return the number in the range [min, max]
     */
    public int getInputNumberInRange(int min, int max) {
        while (true) {
            String input = SCANNER.nextLine().trim(); // read input from the user
            if (validator.isValidInteger(input, true)) { // check validator
                int number = Integer.parseInt(input); // convert string to integer
                if (number >= min && number <= max) { // check range
                    return number;
                } else {
                    LOGGER.log(Level.WARNING, "In-valid number must in range {0} to {1}", new Object[]{min, max});
                }
            } else {
                LOGGER.log(Level.WARNING, "In-valid number must in range {0} to {1}", new Object[]{min, max});
            }
        }
    }

    /**
     * This method is used to read a int from the user and return number
     *
     * @param message the message to display
     * @param errorMessage the error message to display
     */
    public int getInputNumber(String message, String errorMessage) {
        while (true) {
            System.out.print(message); // display message
            String number = SCANNER.nextLine().trim(); // read input from the user
            if (validator.isValidInteger(number, false)) { // check validator
                return Integer.parseInt(number);
            } else {
                System.out.println(errorMessage);
            }
        }
    }

    /**
     * This method is used to read a string from the user and return the string.
     *
     * @param message the message to be shown
     * @param error the error message to be shown
     * @return the string
     */
    public String getInputString(String message, String error) {
        while (true) {
            System.out.print(message); // display message
            String inputString = SCANNER.nextLine().trim(); // read input from the user
            if (validator.isValidString(inputString)) {
                return inputString;
            } else {
                LOGGER.log(Level.WARNING, error);
            }
        }
    }

    /**
     * This method used to read a date from the user and return the local date.
     *
     */
    public String getInputDate() {
        while (true) {
            System.out.print("Please enter a date (dd-MM-yyyy): ");
            String inputDate = SCANNER.nextLine().trim(); // read input from the user
            if (validator.isValidDate(inputDate)) { // check validator
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy"); // declare a formatter object
                LocalDate date = LocalDate.parse(inputDate, formatter); // convert string to local date
                if (date.isAfter(LocalDate.now()) || date.isEqual(LocalDate.now())) { // check date is after today
                    return inputDate; // return the date
                } else {
                    LOGGER.log(Level.WARNING, "The date must be after or equal to today");
                }
            } else {
                LOGGER.log(Level.WARNING, "In-valid date must in format dd-MM-yyyy");
            }
        }
    }

    /**
     * This method is used to return task type.
     *
     * @return string task type
     */
    public String inputTaskType() {
        while (true) {
            System.out.print("Please enter the type of the task [1-Code, 2-Test, 3-Manager, 4-Learn]: ");
            int n = getInputNumberInRange(1, 4);
            switch (n) {
                case 1:
                    return "Code";
                case 2:
                    return "Test";
                case 3:
                    return "Manager";
                case 4:
                    return "Learn";
            }
        }
    }

    /**
     * This method requires the user to enter a time plan from between 8.0 -
     * 17.5 (8h -> 17h30) and returns a string
     *
     * @param message notice to enter
     * @param error the error message to be shown
     * @return plan number in range 8.0 -> 17.5
     */
    public float getInputPlan(float planFrom, float planTo, String message, String error) {
        while (true) {
            System.out.print(message);
            String inputPlan = SCANNER.nextLine().trim();
            try {
                float planTime = Float.parseFloat(inputPlan); // convert string to float
                if (planTime >= planFrom && planTime <= planTo && planTime % 0.5 == 0) {
                    return planTime;
                } else {
                    LOGGER.log(Level.WARNING, error);
                }
            } catch (NumberFormatException e) {
                LOGGER.log(Level.WARNING, "The plan is not valid!");
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
            String input = SCANNER.nextLine().trim();
            if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n")) {
                return input.equalsIgnoreCase("y");
            } else {
                LOGGER.log(Level.WARNING, "In-valid (ex: Choose y or n) enter again:");
            }
        }
    }

}
