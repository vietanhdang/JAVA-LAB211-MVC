/*
 * Copyright(C) 2022, Nguyen The Minh.
 * Code: J1.S.P0074 (100 LOC)
 * Title: Write a calculator program (from DCPS’s project)
 */
package matrixcaculator;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * This class contain method to read input from the user.
 *
 * @author Nguyen The Minh
 */
public class InputReader {

    private final Scanner SCANNER = new Scanner(System.in); // Scanner object
    private static final Logger LOGGER = Logger.getLogger(InputReader.class.getName()); // Logger object

    /**
     * This method read input matrix from the user and return it.
     *
     * @param message Message to display to the user.
     * @return array of matrix
     */
    public int[][] getInputMatrix(String message) {
        int row = getInputNumber("Enter Row Matrix  " + message + " : ", "Number of row is digit and must be greater than 0", true); // get row
        int column = getInputNumber("Enter Column Matrix  " + message + " : ", "Number of row is digit and must be greater than 0", true); // get column
        int[][] matrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = getInputNumber(
                        "Enter element of matrix " + message + " [" + (i + 1) + "][" + (j + 1) + "]: ",
                        "Value of matrix is digit", false);
            }
        }
        return matrix;
    }

    /**
     * This method read input size of matrix from the user.
     *
     * @param message      Message to display to the user.
     * @param errorMessage Error message to display to the user.
     * @param isPositive   Check if the input is positive.
     * @return size of matrix
     */
    public int getInputNumber(String message, String errorMessage, boolean isPositive) {
        while (true) {
            System.out.print(message);
            try {
                int input = Integer.parseInt(SCANNER.nextLine().trim());
                if (isPositive && input <= 0) {
                    LOGGER.warning(errorMessage);
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                LOGGER.warning(errorMessage);
            }
        }
    }

    /**
     * This method read input number in range from the user.
     *
     * @param message      Message to display to the user.
     * @param errorMessage Error message to display to the user.
     * @param min          Minimum value of range.
     * @param max          Maximum value of range.
     * @return number in range
     */
    public int getInputNumberInRange(String message, String errorMessage, int min, int max) {
        while (true) {
            System.out.print(message);
            try {
                int input = Integer.parseInt(SCANNER.nextLine().trim());
                if (input < min || input > max) {
                    LOGGER.warning(errorMessage);
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                LOGGER.warning(errorMessage);
            }
        }
    }
}
