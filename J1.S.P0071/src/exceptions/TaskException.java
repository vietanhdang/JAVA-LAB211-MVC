/*
 * Copyright(C) 2022, Nguyen The Minh.
 * Code: J1.S.P0071 (150 LOC)
 * Title: Task management program of CCRM project.
 */
package exceptions;

/**
 * This class contain method throw exception of task class.
 *
 * @author Nguyen The Minh
 */
public class TaskException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * This is the constructor with parameters.
     *
     * @param msg error message is passed in
     */
    public TaskException(String msg) {
        super(msg);
    }

}
