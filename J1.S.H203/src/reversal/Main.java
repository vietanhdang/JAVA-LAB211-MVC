/*
 * Copyright(C) 2021, Nguyen The Minh
 * Code: J1.S.H203 (90 LOC)
 * Title: Reverse Word
 */
package reversal;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class contains method called Reverse that accepts a String as its
 * parameter and prints the words in opposite order, capital letter at begin of
 * sentence.
 *
 * @author Nguyen The Minh
 */
public class Main {

    /**
     * declare a final variable LOGGER to use logging for Main class.
     */
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    /**
     * This method will accept a string and prints the words in opposite order,
     * capital letter at begin of sentence.
     *
     * @param string is an string parameter
     */
    public static void printReverse(String string) {
        Scanner scanner = new Scanner(System.in);
        // check if the empty string is passed, asking the user for input until not empty
        while (string.isEmpty()) {
            LOGGER.log(Level.WARNING, "String is not empty. Enter again: ");
            string = scanner.nextLine();
        }
        String sentences[] = string.trim().split("\\."); //split string into sentences array at dots
        StringBuilder resultAfterProcessing = new StringBuilder(); // save the result after processing sentences
        for (int i = sentences.length - 1; i >= 0; i--) {
            if (sentences[i].length() != 0) {
                String tempWords[] = sentences[i].trim().split("\\s+"); // separate words at spaces
                for (int j = tempWords.length - 1; j >= 0; j--) {
                    if (tempWords.length - 1 == j) {
                        // if it's the first word, replace the first lowercase character with uppercase
                        resultAfterProcessing.append(tempWords[j].replace(tempWords[j].charAt(0), tempWords[j].substring(0, 1).toUpperCase().charAt(0))).append(" ");
                    } else if (j == 0) {
                        // if it's the last word, don't add spaces
                        resultAfterProcessing.append(tempWords[j]);
                    } else {
                        // add space after separating words at space
                        resultAfterProcessing.append(tempWords[j]).append(" ");
                    }
                }
            }
            // if it's a string after the dot and the last words, don't add a dot
            if (string.endsWith(".")) {
                resultAfterProcessing.append(". ");
            } else {
                if (i != 0) {
                    resultAfterProcessing.append(". ");
                }
            }
        }
        System.out.println("Result is: " + resultAfterProcessing);
    }

    /**
     * This is the main method to run the program.
     *
     * @param args
     */
    public static void main(String[] args) {
        printReverse("");
    }
}
