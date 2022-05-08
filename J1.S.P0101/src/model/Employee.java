/*
 * Copyright(C) 2021, Nguyen The Minh
 * Code: J1.S.P0101 (100 LOC)
 * Title: Employee management system
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class declares an object of an employee.
 *
 * @author Nguyen The Minh
 */
public class Employee {

    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private LocalDate DOB;
    private boolean sex;
    private double salary;
    private String egency;

    /**
     * This is the default constructor.
     */
    public Employee() {
    }

    /**
     * This is the constructor with parameters
     *
     * @param id identifies employee
     * @param firstName the first name of employee
     * @param lastName the last name of employee
     * @param phone phone number of employee
     * @param email email of employee
     * @param address address of employee
     * @param DOB date of birth of employee
     * @param sex sex of employee male or female
     * @param salary salary of employee
     * @param egency agency of employee
     */
    public Employee(String id, String firstName, String lastName, String phone, String email, String address,
            String DOB, boolean sex, double salary, String egency) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.DOB = LocalDate.parse(DOB, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.sex = sex;
        this.salary = salary;
        this.egency = egency;
    }

    /**
     * declare a final variable LOGGER to use logging for Employee class.
     */
    private static final Logger LOGGER = Logger.getLogger(Employee.class.getName());

    /**
     * This method get the id of employee
     *
     * @return id of employee is string
     */
    public String getId() {
        return id;
    }

    /**
     * This method set the id of employee
     *
     * @param id the id of employee to set
     */
    public void setId(String id) {
        if (!id.isEmpty()) {
            this.id = id;
        } else {
            LOGGER.log(Level.WARNING, "id of employee is not empty");
        }
    }

    /**
     * This method get the first name of employee
     *
     * @return first name is string
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This method set the first name of employee
     *
     * @param firstName the first name of employee to set
     */
    public void setFirstName(String firstName) {
        if (!firstName.isEmpty()) {
            this.firstName = firstName.replace(firstName.charAt(0), firstName.substring(0, 1).toUpperCase().charAt(0));
        } else {
            LOGGER.log(Level.WARNING, "first name of employee is not empty");
        }
    }

    /**
     * This method get the last name of employee
     *
     * @return last name is string
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This method set the last name of employee
     *
     * @param lastName the last name of employee to set
     */
    public void setLastName(String lastName) {
        if (!lastName.isEmpty()) {
            this.lastName = lastName.replace(lastName.charAt(0), lastName.substring(0, 1).toUpperCase().charAt(0));;
        } else {
            LOGGER.log(Level.WARNING, "last name of employee is not empty");
        }
    }

    /**
     * This method get the phone number of employee
     *
     * @return phone number is string
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method set the phone number of employee
     *
     * @param phone the phone number of employee to set
     */
    public void setPhone(String phone) {
        if (!phone.isEmpty()) {
            this.phone = phone;
        } else {
            LOGGER.log(Level.WARNING, "phone number of employee is not empty");
        }
    }

    /**
     * This method get the email of employee
     *
     * @return email is string
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method set the email of employee
     *
     * @param email the email of employee to set
     */
    public void setEmail(String email) {
        if (email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            this.email = email;
        } else {
            LOGGER.log(Level.WARNING, "email of employee is not valid");
        }
    }

    /**
     * This method get the address of employee
     *
     * @return address is string
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method set the address of employee
     *
     * @param address the address of employee to set
     */
    public void setAddress(String address) {
        if (!address.isEmpty()) {
            this.address = address;
        } else {
            LOGGER.log(Level.WARNING, "address is not empty");
        }
    }

    /**
     * This method get the date of birth of employee
     *
     * @return date of birth is localdate
     */
    public LocalDate getDOB() {
        return DOB;
    }

    /**
     * This method set the DOB of employee
     *
     * @param DOB the date of birth of employee to set
     */
    public void setDOB(String DOB) {
        try {
            this.DOB = LocalDate.parse("04-07-2001", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "date of bird must right format dd-mm-yyyy");
        }
    }

    /**
     * This method get the sex of employee
     *
     * @return 1 is male and 0 is female
     */
    public boolean getSex() {
        return sex;
    }

    /**
     * This method set the sex of employee
     *
     * @param sex the sex of employee to set
     */
    public void setSex(boolean sex) {
        try {
            this.sex = sex;
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "sex of employee must be 0 or 1");
        }
    }

    /**
     * This method get the salary of employee
     *
     * @return salary type is double
     */
    public double getSalary() {
        return salary;
    }

    /**
     * This method set the salary of employee
     *
     * @param salary the salary of employee to set
     */
    public void setSalary(double salary) {
        try {
            if (salary > 0) {
                this.salary = salary;
            } else {
                LOGGER.log(Level.WARNING, "salary of employee must greater than 0");
            }
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "type of salary must be number");
        }
    }

    /**
     * This method get the agency of employee
     *
     * @return agency is string
     */
    public String getEgency() {
        return egency;
    }

    /**
     * This method set the agency of employee
     *
     * @param egency the agency of employee to set
     */
    public void setEgency(String egency) {
        if (!egency.isEmpty()) {
            this.egency = egency;
        } else {
            LOGGER.log(Level.WARNING, "egency of employee is not empty");
        }
    }

    /**
     * This method return a string is info of a employee
     *
     * @return string is info of employee
     */
    @Override
    public String toString() {
        return String.format("%-10s%-15s%-15s%-15s%-25s%-20s%-15s%-10s%-10s%-10s", id, firstName, lastName, phone, email, address, DOB.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), sex ? "Male" : "Female", salary, egency);
    }

}
