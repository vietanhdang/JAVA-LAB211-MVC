/*
 * Copyright(C) 2021, Nguyen The Minh
 * Code: J1.S.P0101 (100 LOC)
 * Title: Employee management system
 */
package utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class contain method require user enter from keyboard and check data
 * until valid.
 *
 * @author Nguyen The Minh
 */
public class InputReader {

    private final Scanner scanner = new Scanner(System.in); // use for enter from keyboard
    private static final Logger LOGGER = Logger.getLogger(InputReader.class.getName()); // use for throw expection

    /**
     * This method check input String
     *
     * @param message message of logger
     * @return String
     */
    public String inputString(String message) {
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.trim().length() > 0) {
                return input;
            } else {
                LOGGER.log(Level.WARNING, message);
            }
        }
    }

    /**
     * This method check input id
     *
     * @return String
     */
    public String inputId() {
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.matches("^[a-zA-Z0-9\\s]+$") && input.trim().length() > 0) {
                return input;
            } else {
                LOGGER.log(Level.WARNING, "In-valid id (ex:HE151212) enter again:");
            }
        }
    }

    /**
     * This method check input phone number
     *
     * @return String
     */
    public String inputPhone() {
        while (true) {
            System.out.print("Enter employee's phone number [not empty and length is 10]: ");
            String input = scanner.nextLine().trim();
            if (input.matches("^[0-9]+$") && input.length() == 10) {
                return input;
            } else {
                LOGGER.log(Level.WARNING, "In-valid phone number (ex:0363655343) enter again:");
            }
        }
    }

    /**
     * This method check input date of birth
     *
     * @return LocalDate
     */
    public String inputDateOfBirth() {
        while (true) {
            System.out.print("Enter employee's birthday [ex: 12-12-2001]: ");
            String input = scanner.nextLine().trim();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            try {
                LocalDate dateOfBirth = LocalDate.parse(input, formatter);
                if (dateOfBirth.isBefore(LocalDate.now().minusYears(18))) {
                    // check date of birth more than 18 years old
                    return input;
                } else {
                    LOGGER.log(Level.WARNING, "Under 18 years old enter again:");
                }
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "In-valid date of birth (ex: 12-12-2001) enter again:");
            }
        }
    }

    /**
     * This method check input gender
     *
     * @return boolean
     */
    public boolean inputSex() {
        while (true) {
            System.out.print("Enter employee's sex [1- Male and 0-Female]: ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("1") || input.equalsIgnoreCase("0")) {
                return input.equalsIgnoreCase("1");
            } else {
                LOGGER.log(Level.WARNING, "In-valid sex (sex must be 1 is male or 0 is female)");
            }
        }
    }

    /**
     * This method check input email
     *
     * @return String
     */
    public String inputEmail() {
        while (true) {
            System.out.print("Enter employee's email [ex: theminh28@gmail.com]: ");
            String input = scanner.nextLine();
            if (input.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
                return input;
            } else {
                LOGGER.log(Level.WARNING, "In-valid email (ex: theminh28@gmail.com) enter again:");
            }
        }
    }

    /**
     * This method check input salary
     *
     * @return double
     */
    public double inputSalary() {
        while (true) {
            System.out.print("Enter employee's salary [not empty]: ");
            try {
                String input = scanner.nextLine().trim();
                if (Double.parseDouble(input) > 0) {
                    return Double.parseDouble(input);
                } else {
                    LOGGER.log(Level.WARNING, "salary of employee must greater than 0");
                }
            } catch (NumberFormatException e) {
                LOGGER.log(Level.WARNING, "In-valid salary (ex:1200) enter again:");
            }
        }
    }

    /**
     * This method check integer number more than 0
     *
     * @param min min number
     * @param max max number
     * @return integer in range [min,max]
     */
    public int inputNumberInRange(int min, int max) {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                if (Integer.parseInt(input) >= min && Integer.parseInt(input) <= max) {
                    return Integer.parseInt(input);
                } else {
                    LOGGER.log(Level.WARNING, "In-valid number must in range {0} to {1}", new Object[]{min, max});
                }
            } catch (NumberFormatException e) {
                LOGGER.log(Level.WARNING, "In-valid number must in range {0} to {1}", new Object[]{min, max});
            }
        }
    }

    /**
     * This method check Yes or No from keyboard
     *
     * @return boolean true if enter y and false if enter n
     */
    public boolean inputYesOrNo() {
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n")) {
                return input.equalsIgnoreCase("y");
            } else {
                LOGGER.log(Level.WARNING, "In-valid (ex:choose y or n) enter again:");
            }
        }
    }
}
