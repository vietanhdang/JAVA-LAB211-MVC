/*
 * Copyright(C) 2022, Nguyen The Minh.
 * Code: J1.S.P0071 (150 LOC)
 * Title: Task management program of CCRM project.
 */
package view;

import java.util.logging.Level;
import java.util.logging.Logger;
import controller.TaskController;
import exceptions.TaskException;
import model.Task;
import utility.InputReader;

/**
 * This class contain method create,delete, display tasks.
 *
 * @author Nguyen The Minh
 */
public class TaskView {

    private final InputReader inputReader = new InputReader(); // declare a inputReader object to read input from the
    // user.
    public TaskController taskController = new TaskController(); // declare a taskController object to process the task.
    private static final Logger LOGGER = Logger.getLogger(TaskView.class.getName()); // declare a logger object to log
    // the error.

    /**
     * This method print title bar info of task.
     *
     */
    public void printTitleBar() {
        System.out.printf("|%-5s|%-25s|%-12s|%-20s|%-6s|%-20s|%-20s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
    }

    /**
     * This method display menu of this program and return the choice of user.
     *
     */
    public int displayMenu() {
        System.out.println("=========== Task Management Program ===========");
        System.out.println("1. Add task");
        System.out.println("2. Delete task");
        System.out.println("3. Display task");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        return inputReader.getInputNumberInRange(1, 4);
    }

    /**
     * This method is used to add a task to the task list.
     *
     * @throws Exception
     */
    public void addTask() throws TaskException {
        boolean checkAddMore = true;
        do {
            System.out.println("========== ADD TASK ==========");
            String requirementName = inputReader.getInputString("Enter Requirement Name: ", "Requirement Name is required!");
            String taskType = inputReader.inputTaskType();
            String date = inputReader.getInputDate();
            float planFrom = inputReader.getInputPlan(7.5f, 17f, "Enter Plan From in range [8.0,17.5): ",
                    "The plan from must be in range [8.0,17.5)");
            float planTo;
            while (true) { // check plan to is more than plan from
                planTo = inputReader.getInputPlan(8.5f, 17.5f, "Enter Plan To in range (8.0,17.5]: ",
                        "The plan from must greater than plan from and must be in range [8.0,17.5)");
                if (planTo > planFrom) { // check planTo is greater than planFrom
                    break;
                }
                LOGGER.log(Level.WARNING, "Plan To must be greater than Plan From");
            }
            String assign = inputReader.getInputString("Enter Assign: ", "Assign is required!");
            String reviewer = inputReader.getInputString("Enter Reviewer: ", "Reviewer is required!");
            if (taskController.addTask(requirementName, taskType, date, planFrom, planTo, assign, reviewer) != -1) { // if add task success and return id is not equal -1
                System.out.println("Add task successfully!");
                System.out.println("================================");
                System.out.print("Do you want to add another task? (Y/N): ");
                checkAddMore = inputReader.getInputYesOrNo();
            } else {
                System.out.println("Add task error!");
                System.out.println("================================");
                break;
            }
        } while (checkAddMore);
    }

    /**
     * This method is used to delete a task from the task list.
     *
     * @throws Exception
     */
    public void deleteTask() throws TaskException {
        boolean checkDeleteMore;
        do {
            System.out.println("========== DELETE TASK ==========");
            System.out.println("Enter ID of task to delete: ");
            int id = inputReader.getInputNumber("Enter ID of task: ", "ID is not valid!");
            Task task = taskController.getTaskById(id);
            if (task == null) {
                System.out.println("Task not found!");
                System.out.println("================================");
                System.out.print("Do you want to delete another task? (Y/N): ");
                checkDeleteMore = inputReader.getInputYesOrNo();
            } else {
                System.out.println("Has found task: ");
                printTitleBar();
                task.displayTask();
                System.out.println("================================");
                System.out.print("Do you really want to delete this task? (Y/N): ");
                if (inputReader.getInputYesOrNo()) {
                    taskController.removeTask(id);
                    System.out.println("Delete task successfully!");
                    System.out.println("================================");
                } else {
                    System.out.println("Delete task cancelled!");
                }
                System.out.print("Do you want to delete another task? (Y/N): ");
                checkDeleteMore = inputReader.getInputYesOrNo();
            }
        } while (checkDeleteMore);
    }

    /**
     * This method is used to display all task in the task list.
     */
    public void displayTask() {
        System.out.println("========== DISPLAY TASK ==========");
        if (taskController.getDataTasks().isEmpty()) {
            System.out.println("No task found!");
        } else {
            System.out.println("List of task: ");
            printTitleBar();
            taskController.getDataTasks().forEach((task) -> {
                task.displayTask();
            });
        }
    }
}
