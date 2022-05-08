/*
 * Copyright(C) 2022, Nguyen The Minh.
 * Code: J1.S.P0071 (150 LOC)
 * Title: Task management program of CCRM project.
 */
package utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * This class contain method to check validate.
 *
 * @author Nguyen The Minh
 */
public class Validator {

    /**
     * This method is used to check validate of string.
     *
     * @param input input string
     * @return true if input is valid, false if input is invalid
     */
    public boolean isValidString(String input) {
        return input != null && !input.isEmpty(); // if input is null or empty, return false
    }

    /**
     * This method is used to check validate of integer.
     *
     * @param input input integer
     * @return true if input is valid, false if input is invalid
     */
    public boolean isValidInteger(String input, boolean isPositive) {
        try {
            int number = Integer.parseInt(input); // convert string to integer
            if (isPositive) { // check if number is positive
                return number > 0;
            } else {
                return true;
            }
        } catch (NumberFormatException e) { // if input is not integer
            return false;
        }
    }

    /**
     * This method is used to check validate of date.
     *
     * @param input input date
     * @return true if input is valid, false if input is invalid
     */
    public boolean isValidDate(String input) {
        try {
            DateFormat df = new SimpleDateFormat("d-M-yyyy"); // set format date
            df.setLenient(false); // set lenient to false
            df.parse(input); // parse the string into date
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

}
