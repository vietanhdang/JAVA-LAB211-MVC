/*
 * Copyright(C) 2022, Nguyen The Minh.
 * Code: J1.S.P0070 (150 LOC)
 * Title: Login system of the Tien Phong Bank’s Ebank
 */
package login;

import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * This class is used to perform process login
 *
 * @author Nguyen The Minh
 */
public class Ebank {

    ResourceBundle message; // Resource bundle
    public final Scanner SCANNER = new Scanner(System.in); // Scanner object

    /**
     * This method is used to set the language.
     */
    public void setLocate(Locale locale) {
        message = ResourceBundle.getBundle("language/" + locale);
    }

    /**
     * This method is used to check account number.
     *
     * @param accountNumber is the account number.
     * @return String is the account number.
     */
    public String checkAccountNumber(String accountNumber) {
        if (accountNumber.matches("^[0-9]{10}$")) {
            return "true";
        } else {
            return message.getString("errorAccountNumberFormat");
        }
    }

    /**
     * This method is used to check password.
     *
     * @param password is the password.
     * @return String is the password.
     */
    public String checkPassword(String password) {
        // Check the password at least have one alphabet and one number
        if (password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@#$%]{8,31}$")) {
            return "true";
        } else {
            return message.getString("errorPasswordAlphanumeric");
        }

    }

    /**
     * This method is used to generate random captcha.
     *
     * @return String is the captcha.
     */
    public static String generateCaptcha() {
        Random random = new Random();
        char[] chars = {'1', 'A', 'a', 'B', 'b', 'C',
            'c', '2', 'D', 'd', 'E', 'e', 'F', 'f', '3', 'G', 'g', 'H', 'h',
            'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l', '4', 'M', 'm', 'N', 'n',
            'O', 'o', '5', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't',
            '6', '7', 'U', 'u', 'V', 'v', 'U', 'u', 'W', 'w', '8', 'X', 'x',
            'Y', 'y', 'Z', 'z', '9'};
        while (true) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < 5; i++) {
                int index = random.nextInt(chars.length - 1);
                result.append(chars[index]);
            }
            if (result.toString().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{5}")) {
                return result.toString();
            }
        }
    }

    /**
     * This method is used to check captcha input and captcha generated.
     *
     * @param captchaInput is the captcha input.
     * @param captchaGenerate is the captcha generated.
     * @return String is the captcha.
     */
    public String checkCaptcha(String captchaInput, String captchaGenerate) {
        if (captchaGenerate.contains(captchaInput) && !captchaInput.isEmpty()) {
            return "true";
        } else {
            return message.getString("errorCaptchaCode");
        }
    }

    /**
     * This method get number in range min to max from user.
     *
     * @param min is the minimum number.
     * @param max is the maximum number.
     * @param language is the language of the word.
     * @return the number in range min to max.
     */
    public int getNumberInRange(int min, int max, Locale curLocate) {
        while (true) {
            try {
                int number = Integer.parseInt(SCANNER.nextLine().trim());
                if (number < min || number > max) {
                    System.out.println(message.getString("errorNumberInRange"));
                } else {
                    return number;
                }
            } catch (NumberFormatException ex) {
                System.out.println(message.getString("errorNumberFormat"));
            }
        }
    }

    /**
     * This method get account number from user.
     *
     * @param language is the language of the word.
     * @return the account number.
     */
    public String getAccountNumber() {
        while (true) {
            System.out.print(message.getString("inputAccountNumber"));
            String accountNumber = SCANNER.nextLine().trim();
            // Check if accountNumber is number and length is 10
            String checkAccountNumber = checkAccountNumber(accountNumber);
            if (checkAccountNumber.equalsIgnoreCase("true")) {
                return accountNumber;
            } else {
                System.out.println(checkAccountNumber);
            }
        }
    }

    /**
     * This method get password from user.
     *
     * @param language is the language of the word.
     * @return the password.
     */
    public String getPassword() {
        while (true) {
            System.out.print(message.getString("inputPassword"));
            String password = SCANNER.nextLine().trim();
            // Check password length must be between 8 and 31 and have at least 1 letter and
            // 1 number
            String checkPassword = checkPassword(password);
            if (checkPassword.equalsIgnoreCase("true")) {
                return password;
            } else {
                System.out.println(checkPassword);
            }
        }
    }

    /**
     * This method use for login.
     *
     * @param language is the language of the word.
     */
    public void login() {
        String accountNumber = getAccountNumber(); // Get account number from user
        String password = getPassword(); // Get password from user
        if (!accountNumber.isEmpty() && !password.isEmpty()) { // Check account number and password is not null
            while (true) {
                String captchaCode = generateCaptcha(); // Generate captcha code
                System.out.println(message.getString("captchaCode") + ": " + captchaCode); // Show captcha code
                System.out.print(message.getString("inputCaptchaCode"));
                String inputCaptchaCode = SCANNER.nextLine(); // Get captcha code from user
                if (checkCaptcha(inputCaptchaCode, captchaCode).equals("true")) { // Check captcha code is correct
                    System.out.println(message.getString("loginSuccess"));
                    return;
                } else {
                    System.out.println(message.getString("loginFail"));
                }
            }
        }
    }

}
