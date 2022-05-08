/*
 * Copyright(C) 2022, Nguyen The Minh.
 * Code: J1.S.P0071 (150 LOC)
 * Title: Task management program of CCRM project.
 */
package view;

import exceptions.TaskException;

/**
 * This class using to run program
 *
 * @author Nguyen The Minh
 */
public class Main {

    /**
     * This method is used to run the program.
     *
     * @param args is the arguments of the program.
     *
     */
    public static void main(String[] args) throws TaskException {
        TaskView taskView = new TaskView();
        // add sample data
        taskView.taskController.addTask("Nguyen The Minh", "Learn", "16-04-2022", 8f, 10.5f, "khaitq", "trngnv");
        taskView.taskController.addTask("Le Minh Toan", "Learn", "17-04-2022", 8.5f, 11.5f, "khaitq", "trngnv");
        taskView.taskController.addTask("Tran Hai Phong", "Learn", "18-04-2022", 8.5f, 12.5f, "khaitq", "trngnv");
        taskView.taskController.addTask("Nguyen Tien Dat", "Learn", "19-04-2022", 8.5f, 13.5f, "khaitq", "trngnv");
        int choice = 0;
        do {
            choice = taskView.displayMenu(); // display menu and return choice
            switch (choice) {
                case 1:
                    taskView.addTask(); // add task function
                    break;
                case 2:
                    taskView.deleteTask(); // delete task by id function
                    break;
                case 3:
                    taskView.displayTask(); // display task function
                    break;
            }
        } while (choice != 4);
    }
}
