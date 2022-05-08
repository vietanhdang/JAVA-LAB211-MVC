/*
 * Copyright(C) 2021, Nguyen The Minh
 * Code: J1.S.P0101 (100 LOC)
 * Title: Employee management system
 */
package controller;

import java.util.ArrayList;
import java.util.Collections;
import model.Employee;

/**
 * This class contain method process employee.
 *
 * @author Nguyen The Minh
 */
public class EmployeeController {

    private final ArrayList<Employee> listEmployee = new ArrayList<>(); // initialize the list containing the employees

    /**
     * This method to get the list of employees
     *
     * @return ArrayList<Employee> list Employee is ArrayList
     */
    public ArrayList<Employee> getListEmployee() {
        return listEmployee;
    }

    /**
     * This method to find employee by id
     *
     * @param id id of employee
     * @return <Employee> object
     *
     */
    public Employee findEmployeeById(String id) {
        for (Employee employee : listEmployee) {
            if (employee.getId().equalsIgnoreCase(id)) {
                return employee;
            }
        }
        return null;
    }

    /**
     * This method to add employee
     *
     * @param employee employee object
     * @return boolean true if add success and false if add failed
     *
     */
    public boolean addEmployee(Employee employee) {
        return listEmployee.add(employee);
    }

    /**
     * This method to remove employee
     *
     * @param employee employee object
     * @return boolean true if remove success and false if remove failed
     *
     */
    public boolean removeEmployee(Employee employee) {
        return listEmployee.remove(employee);
    }

    /**
     * This method to search employee by name
     *
     * @param name name of employee
     * @return ArrayList<Employee> contains list employees search by name
     *
     */
    public ArrayList<Employee> searchEmployeeByName(String name) {
        ArrayList<Employee> employees = new ArrayList<>(); // the list contains the employee after searching
        name = name.toLowerCase().trim();
        if (name.isEmpty()) {
            return employees;
        }
        for (Employee employee : listEmployee) {
            String fullName = (employee.getFirstName() + " " + employee.getLastName()).toLowerCase();
            if (name.equalsIgnoreCase(employee.getFirstName())
                    || name.equalsIgnoreCase(employee.getLastName())
                    || fullName.contains(name) == true) {
                employees.add(employee);
            }
        }
        return employees;
    }

    /**
     * This method to sort employee by salary
     *
     * @return ArrayList<Employee> contains list employees after sort by salary
     *
     */
    public ArrayList<Employee> sortBySalary() {
        Collections.sort(listEmployee, (Employee o1, Employee o2) -> (int) (o1.getSalary() - o2.getSalary()));
        return listEmployee;
    }
}
