/*
 * Copyright(C) 2022, Nguyen The Minh.
 * Code: J1.S.P0074 (100 LOC)
 * Title: Write a calculator program (from DCPS’s project)
 */
package matrixcaculator;

/**
 * This class contain method calculate matrix.
 *
 * @author Nguyen The Minh
 */
public class Caculator {

    /**
     * This method print menu of calculator.
     */
    public int printMenu() {
        InputReader inputReader = new InputReader();
        System.out.println("==========MATRIX CALCULATOR==========");
        System.out.println("1. Addition of two matrix");
        System.out.println("2. Subtraction of two matrix");
        System.out.println("3. Multiplication of two matrix");
        System.out.println("4. Exit");
        return inputReader.getInputNumberInRange("Please choose an option: ",
                "Invalid input must be a number in range 1-4", 1, 4);
    }

    /**
     * This method print matrix to the screen.
     * 
     * @param matrix matrix to print
     */
    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println("");
        }
    }

    /**
     * This method add two matrix.
     * 
     * @param matrix1 first matrix
     * @param matrix2 second matrix
     * @return result of add two matrix
     *
     */
    public int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            // if row of matrix1 != row of matrix2 or column of matrix1 != column of matrix2
            // => can't add
            return null;
        }
        int[][] result = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    /**
     * This method subtract two matrix.
     *
     * @return result of subtraction
     *
     */
    public int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            // if row of matrix1 != row of matrix2 or column of matrix1 != column of matrix2
            // => can't subtract
            return null;
        }
        int[][] result = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    /**
     * This method multiply two matrix.
     *
     * @return result of multiplication
     *
     */
    public int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        if (matrix1[0].length != matrix2.length) {
            // if column of matrix1 != row of matrix2
            return null;
        }
        int[][] result = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    /**
     * This is main method of this class which call other method to calculate
     * matrix.
     *
     * @param args
     */
    public static void main(String[] args) {
        Caculator caculator = new Caculator(); // Create object of class Caculator
        InputReader inputReader = new InputReader(); // Create object of class InputReader
        int[][] matrix1; // initialize matrix1
        int[][] matrix2; // initialize matrix2
        int[][] result; // initialize result
        while (true) {
            int choice = caculator.printMenu(); // Print menu and get choice of user
            switch (choice) {
                case 1:
                    // Addition of two matrix
                    matrix1 = inputReader.getInputMatrix("1");
                    matrix2 = inputReader.getInputMatrix("2");
                    result = caculator.additionMatrix(matrix1, matrix2); // Multiplication of two matrix
                    if (result != null) {
                        System.out.println("----------RESULT OF ADDITION----------");
                        caculator.printMatrix(matrix1);
                        System.out.println("+");
                        caculator.printMatrix(matrix2);
                        System.out.println("=");
                        caculator.printMatrix(result);
                    } else {
                        System.out.println("The size of 2 matrix is not equal!");
                    }
                    break;
                case 2:
                    // Subtraction of two matrix
                    matrix1 = inputReader.getInputMatrix("1");
                    matrix2 = inputReader.getInputMatrix("2");
                    result = caculator.subtractionMatrix(matrix1, matrix2); // Multiplication of two matrix
                    if (result != null) {
                        System.out.println("----------RESULT OF SUBTRACTION----------");
                        caculator.printMatrix(matrix1);
                        System.out.println("-");
                        caculator.printMatrix(matrix2);
                        System.out.println("=");
                        caculator.printMatrix(result);
                    } else {
                        System.out.println("The size of 2 matrix is not equal!");
                    }
                    break;
                case 3:
                    // Multiplication of two matrix
                    matrix1 = inputReader.getInputMatrix("1");
                    matrix2 = inputReader.getInputMatrix("2");
                    result = caculator.multiplicationMatrix(matrix1, matrix2); // Multiplication of two matrix
                    if (result != null) {
                        System.out.println("----------RESULT OF MULTIPLICATION----------");
                        caculator.printMatrix(matrix1);
                        System.out.println("*");
                        caculator.printMatrix(matrix2);
                        System.out.println("=");
                        caculator.printMatrix(result);
                    } else {
                        System.out.println("The size column of matrix1 is not equal to row of matrix2!");
                    }
                    break;
                case 4:
                    // Exit
                    System.out.println("Exit!");
                    System.exit(0);
            }
        }
    }

}
