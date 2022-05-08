/*
 * Copyright(C) 2021, Nguyen The Minh
 * Code: J1.S.P0071 (150 LOC)
 * Title: Task management program of CCRM project
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import exceptions.TaskException;
import utility.Validator;

/**
 * This class declares an object of a task.
 *
 * @author Nguyen The Minh
 */
public class Task {

    private int id;
    private String taskType;
    private String requirementName;
    private LocalDate date;
    private float planFrom;
    private float planTo;
    private String assign;
    private String reviewer;

    /**
     * Creates a default constructor for the task.
     */
    public Task() {
    }

    /**
     * This is the constructor with parameters.
     *
     * @param id the id of the task
     * @param requirementName the name of the requirement
     * @param taskType the type of the task
     * @param date the date of the task
     * @param planFrom the plan from
     * @param planTo the plan to
     * @param assign the assignee of the task
     * @param reviewer the reviewer of the task
     * @throws Exception if the date is invalid
     */
    public Task(String requirementName, String taskType, LocalDate date, float planFrom, float planTo,
            String assign, String reviewer) throws TaskException {
        this.taskType = taskType;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assign = assign;
        this.reviewer = reviewer;
    }

    /**
     * This method is used to get the id of the task.
     *
     * @return the id of the task
     */
    public int getId() {
        return id;
    }

    /**
     * This method is used to set the id of the task.
     *
     * @param id the id of the task
     * @throws Exception if the task id is invalid
     *
     */
    public void setId(int id) throws TaskException {
        if (id < 0) {
            throw new TaskException("The id must be greater than 0.");
        }
        this.id = id;
    }

    /**
     * This method is used to get the type of the task.
     *
     * @return string the type of the task
     *
     */
    public String getTaskType() {
        return taskType;
    }

    /**
     * This method is used to set the type of the task.
     *
     * @param taskType the type of the task
     * @throws Exception if the task type is invalid
     */
    public void setTaskType(String taskType) throws TaskException {
        if (taskType == null || taskType.isEmpty()) {
            throw new TaskException("The task type must not be empty.");
        }
        this.taskType = taskType;
    }

    /**
     * This method is used to get the requirement name of the task.
     *
     * @return string the requirement name of the task
     *
     */
    public String getRequirementName() {
        return requirementName;
    }

    /**
     * This method is used to set the requirement name of the task.
     *
     * @param requirementName the requirement name of the task
     * @throws Exception if the requirement name is invalid
     */
    public void setRequirementName(String requirementName) throws TaskException {
        if (requirementName == null || requirementName.isEmpty()) {
            throw new TaskException("The requirement name must not be empty.");
        }
        this.requirementName = requirementName;
    }

    /**
     * This method is used to get the date of the task.
     *
     * @return LocalDate the date of the task
     *
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * This method is used to set the date of the task.
     *
     * @param date the date of the task
     * @throws Exception if the date is invalid
     */
    public void setDate(String date) throws TaskException {
        Validator validator = new Validator();
        if (!validator.isValidDate(date)) {
            throw new TaskException("The date must not be empty and right formart dd-MM-yyyy");
        }
        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("d-M-yyyy"));
    }

    /**
     * This method is used to get the plan from of the task.
     *
     * @return float the plan from of the task
     *
     */
    public float getPlanFrom() {
        return planFrom;
    }

    /**
     * This method is used to set the plan from of the task.
     *
     * @param planFrom the plan from of the task
     * @throws Exception if the plan from is invalid
     */
    public void setPlanFrom(float planFrom) throws TaskException {
        if (planFrom < 0) {
            throw new TaskException("The plan from must be greater than 0.");
        }
        this.planFrom = planFrom;
    }

    /**
     * This method is used to get the plan to of the task.
     *
     * @return float the plan to of the task
     *
     */
    public float getPlanTo() {
        return planTo;
    }

    /**
     * This method is used to set the plan to of the task.
     *
     * @param planTo the plan to of the task
     * @throws Exception if the plan to is invalid
     */
    public void setPlanTo(float planTo) throws TaskException {
        if (planTo < 0) {
            throw new TaskException("The plan to must be greater than 0.");
        }
        this.planTo = planTo;
    }

    /**
     * This method is used to get the assignee of the task.
     *
     * @return string the assignee of the task
     *
     */
    public String getAssign() {
        return assign;
    }

    /**
     * This method is used to set the assignee of the task.
     *
     * @param assign the assignee of the task
     * @throws Exception if the assignee is invalid
     */
    public void setAssign(String assign) throws TaskException {
        Validator validator = new Validator();
        if (!validator.isValidString(assign)) {
            throw new TaskException("The assignee must not be empty.");
        }
        this.assign = assign;
    }

    /**
     * This method is used to get the reviewer of the task.
     *
     * @return string the reviewer of the task
     *
     */
    public String getReviewer() {
        return reviewer;
    }

    /**
     * This method is used to set the reviewer of the task.
     *
     * @param reviewer the reviewer of the task
     * @throws Exception if the reviewer is invalid
     */
    public void setReviewer(String reviewer) throws TaskException {
        Validator validator = new Validator();
        if (!validator.isValidString(reviewer)) {
            throw new TaskException("The reviewer must not be empty.");
        }
        this.reviewer = reviewer;
    }

    /**
     * This method to display information of task info
     */
    public void displayTask() {
        System.out.printf("|%-5d|%-25s|%-12s|%-20s|%-6.1f|%-20s|%-20s\n", id, requirementName, taskType,
                date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), planTo - planFrom, assign, reviewer);
    }
}
