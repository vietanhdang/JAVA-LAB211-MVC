/*
 * Copyright(C) 2021, Nguyen The Minh
 * Code: J1.S.P0101 (100 LOC)
 * Title: Employee management system
 */
package view;

import controller.EmployeeController;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;
import utility.InputReader;

/**
 * This class contain method create, remove, update, and read employee
 *
 * @author Nguyen The Minh
 */
public class EmployeeView {

    private final InputReader inputReader = new InputReader(); // user for input reader
    public EmployeeController employeeController = new EmployeeController(); // handle employee in controller
    private static final Logger LOGGER = Logger.getLogger(EmployeeView.class.getName()); // use for logging throw expection

    /**
     * This method print title bar info of employee
     */
    public void printTitleBar() {
        System.out.println(String.format("%-10s%-15s%-15s%-15s%-25s%-20s%-15s%-10s%-10s%-10s", "ID", "First Name",
                "Last Name", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Egency"));
    }

    /**
     * This method display menu of this program and return number corresponding
     * method enter from keyboard
     */
    public int displayMenu() {
        System.out.println("Main menu: ");
        System.out.println("1. Add new employee");
        System.out.println("2. Update employee");
        System.out.println("3. Remove employee");
        System.out.println("4. Search employee");
        System.out.println("5. Sort employee");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        return inputReader.inputNumberInRange(1, 6);
    }

    /**
     * This method create employee
     *
     */
    public void addEmployee() {
        boolean checkAddMore = true;
        do {
            Employee employee = new Employee();
            System.out.println("Enter employee's information");
            System.out.print("Enter employee's id [ex: HE151212]: ");
            while (true) {
                String id = inputReader.inputId();
                if (employeeController.findEmployeeById(id) != null) {
                    LOGGER.log(Level.WARNING, "Sorry. Already have id in the list. Enter again:");
                    System.out.print("Do you want to add more employee? (Y/N): ");
                    checkAddMore = inputReader.inputYesOrNo();
                } else {
                    employee.setId(id);
                    break;
                }
            }
            System.out.print("Enter employee's first name [not-empty]: ");
            employee.setFirstName(inputReader.inputString("First name is not empty. Enter again!"));
            System.out.print("Enter employee's last name [not empty]: ");
            employee.setLastName(inputReader.inputString("Last name is not empty. Enter again!"));
            employee.setPhone(inputReader.inputPhone());
            employee.setEmail(inputReader.inputEmail());
            System.out.print("Enter employee's address [not empty]: ");
            employee.setAddress(inputReader.inputString("Address is not empty. Enter again!"));
            employee.setDOB(inputReader.inputDateOfBirth());
            employee.setSex(inputReader.inputSex());
            employee.setSalary(inputReader.inputSalary());
            System.out.print("Enter employee's egency [not empty]: ");
            employee.setEgency(inputReader.inputString("Egency is not empty. Enter again!"));
            employeeController.addEmployee(employee);
            System.out.print("Do you want to add more employee? (Y/N): ");
            checkAddMore = inputReader.inputYesOrNo();
        } while (checkAddMore);
    }

    /**
     * This method remove employee
     *
     */
    public void removeEmployee() {
        boolean checkRemoveMore = true;
        do {
            System.out.print("Enter employee's id to remove [ex: HE151212]: ");
            String id = inputReader.inputId();
            Employee employee = employeeController.findEmployeeById(id);
            if (employee == null) {
                LOGGER.log(Level.WARNING, "Sorry. Can''t find employee with id: {0}", id);
                System.out.print("Do you want to remove more employee? (Y/N): ");
                checkRemoveMore = inputReader.inputYesOrNo();
            } else {
                System.out.println("Employee has id: " + id + " is founded!");
                printTitleBar();
                System.out.println(employee.toString());
                System.out.print("Do you really want to remove employee has id " + id + " (Y/N):");
                if (inputReader.inputYesOrNo()) {
                    if (employeeController.removeEmployee(employee)) {
                        System.out.println("Remove employee success!");
                    } else {
                        System.out.println("Remove employee failed!");
                    }
                } else {
                    System.out.println("Remove employee cancel!");
                }
            }
            System.out.print("Do you want to remove more employee? (Y/N): ");
            checkRemoveMore = inputReader.inputYesOrNo();
        } while (checkRemoveMore);
    }

    /**
     * This method update employee
     *
     */
    public void updateEmployee() {
        boolean checkUpdateMore = true;
        do {
            System.out.print("Enter employee's id [ex: HE151212]: ");
            String id = inputReader.inputId();
            Employee employee = employeeController.findEmployeeById(id);
            if (employee == null) {
                LOGGER.log(Level.WARNING, "Sorry. Can''t find employee with id: {0}", id);
                System.out.print("Do you want to update more employee? (Y/N): ");
                checkUpdateMore = inputReader.inputYesOrNo();
            } else {
                System.out.println("Employee has id: " + id + " is founded!");
                int options = 0;
                while (options != 10) {
                    printTitleBar();
                    System.out.println(employee.toString());
                    System.out.println("what are you want update?");
                    System.out.println("1.  First Name");
                    System.out.println("2.  Last Name");
                    System.out.println("3.  Phone");
                    System.out.println("4.  Email");
                    System.out.println("5.  Address");
                    System.out.println("6.  DOB");
                    System.out.println("7.  Sex");
                    System.out.println("8.  Salary");
                    System.out.println("9.  Agency");
                    System.out.println("10. Exit");
                    System.out.println("");
                    System.out.print("Select a option: ");
                    options = inputReader.inputNumberInRange(1, 10);
                    switch (options) {
                        case 1:
                            System.out.print("Enter New First Name: ");
                            employee.setFirstName(inputReader.inputString("First name is not empty. Enter again!"));
                            break;
                        case 2:
                            System.out.print("Enter New Last Name: ");
                            employee.setLastName(inputReader.inputString("Last name is not empty. Enter again!"));
                            break;
                        case 3:
                            employee.setPhone(inputReader.inputPhone());
                            break;
                        case 4:
                            employee.setEmail(inputReader.inputEmail());
                            break;
                        case 5:
                            System.out.print("Enter New Address: ");
                            employee.setAddress(inputReader.inputString("Address is not empty. Enter again!"));
                            break;
                        case 6:
                            employee.setDOB(inputReader.inputDateOfBirth());
                            break;
                        case 7:
                            employee.setSex(inputReader.inputSex());
                            break;
                        case 8:
                            employee.setSalary(inputReader.inputSalary());
                            break;
                        case 9:
                            System.out.print("Enter New Agency: ");
                            employee.setEgency(inputReader.inputString("Egency is not empty. Enter again!"));
                            break;
                    }
                    System.out.println("Update employee success!");
                }
                System.out.print("Do you want to update more employee? (Y/N): ");
                checkUpdateMore = inputReader.inputYesOrNo();
            }
        } while (checkUpdateMore);
    }

    /**
     * This method search employee
     *
     */
    public void searchEmployee() {
        boolean checkSearchMore = true;
        do {
            System.out.print("Enter name: ");
            String name = inputReader.inputString("Name is not empty. Enter again!");
            ArrayList<Employee> employees = employeeController.searchEmployeeByName(name);
            if (employees.isEmpty()) {
                LOGGER.log(Level.WARNING, "Sorry. Can't find employee with name: {0}", name);
            } else {
                System.out.println("Total " + employees.size() + " Employees has name: " + name + " is founded!");
                printTitleBar();
                for (Employee employee : employees) {
                    System.out.println(employee.toString());
                }
            }
            System.out.print("Do you want to search more employee? (Y/N): ");
            checkSearchMore = inputReader.inputYesOrNo();
        } while (checkSearchMore);
    }

    /**
     *
     * This method print list employees sort by salary
     *
     */
    public void sortEmployeeBySalary() {
        printTitleBar();
        employeeController.sortBySalary().forEach((employee) -> {
            System.out.println(employee.toString());
        });
    }
}
