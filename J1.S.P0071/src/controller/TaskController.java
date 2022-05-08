/*
 * Copyright(C) 2022, Nguyen The Minh.
 * Code: J1.S.P0071 (150 LOC)
 * Title: Task management program of CCRM project.
 */
package controller;

import exceptions.TaskException;
import java.util.ArrayList;

import model.Task;

/**
 * This class contains method processing the task.
 *
 * @author Nguyen The Minh
 */
public class TaskController {
    
    private final ArrayList<Task> taskList = new ArrayList<>();

    /**
     * This method is used to get the task list.
     *
     * @return the task list
     */
    public ArrayList<Task> getDataTasks() {
        return taskList;
    }

    /**
     * This method is used to add a task to the task list.
     *
     * @param task the task to be added
     */
    public int addTask(String requirementName, String taskType, String date, float planFrom, float planTo,
            String assign, String reviewer) throws TaskException {
        Task task = new Task();
        if (!taskList.isEmpty()) {
            task.setId(taskList.get(taskList.size() - 1).getId() + 1);
        } else {
            task.setId(1);
        }
        task.setRequirementName(requirementName); // set requirement name of task
        task.setTaskType(taskType); // set task type of task
        task.setDate(date); // set date of task
        task.setPlanFrom(planFrom); // set plan from of task
        task.setPlanTo(planTo); // set plan to of task
        task.setAssign(assign); // set assign of task
        task.setReviewer(reviewer); // set reviewer of task
        if (taskList.add(task)) {
            return task.getId();
        } else {
            return - 1;
        }
    }

    /**
     * This method is used to remove a task from the task list.
     *
     * @param task the task to be removed
     */
    public boolean removeTask(int id) throws TaskException {
        Task task = getTaskById(id);
        if (task != null) {
            taskList.remove(task);
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method is used to get the task by id.
     *
     * @param id the id of the task
     * @return the task
     */
    public Task getTaskById(int id) {
        for (Task task : taskList) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
}
