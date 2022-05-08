/*
 * Copyright(C) 2021, Nguyen The Minh
 * Code: J1.S.P0101 (100 LOC)
 * Title: Employee management system
 */
package view;

import model.Employee;

/**
 * This class using to run program
 *
 * @author Nguyen The Minh
 */
public class Main {

    public static void main(String[] args) {
        EmployeeView employeeView = new EmployeeView(); // call from EmployeeView
        // add sample employee
        employeeView.employeeController.addEmployee(
                new Employee("HE121212", "Hoang", "Hai Minh", "0368332828", "minhdvdsa@fpt.edu.vn",
                        "Bac Ninh", "01-03-2002", true, 1100, "IT"));
        employeeView.employeeController.addEmployee(
                new Employee("HE121213", "Dinh", "Tuan Phong", "0332142343", "phongdt@fpt.edu.vn",
                        "Son la", "12-12-2003", true, 2000, "Senior"));
        employeeView.employeeController.addEmployee(
                new Employee("HE121214", "Kieu", "Tu Tai", "0334567453", "taikt@fpt.edu.vn",
                        "Phu Tho", "03-04-2000", true, 900, "Techical"));
        employeeView.employeeController.addEmployee(
                new Employee("HE121215", "Dang", "Van Long", "036835464", "longvd@fpt.edu.vn",
                        "Hung yen", "04-08-1999", true, 200, "Support"));
        int choice = 0;
        while (choice != 6) {
            choice = employeeView.displayMenu(); // display menu and return choice
            switch (choice) {
                case 1:
                    employeeView.addEmployee(); // add employee function
                    break;
                case 2:
                    employeeView.updateEmployee(); // update employee by id function
                    break;
                case 3:
                    employeeView.removeEmployee(); // remove employee by id function
                    break;
                case 4:
                    employeeView.searchEmployee(); // search employee by name function
                    break;
                case 5:
                    employeeView.sortEmployeeBySalary(); // sort employee by salary function
                    break;
            }
        }
    }
}
