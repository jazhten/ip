package Utility;

import TaskClasses.Task;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The list of tasks that are currently assigned to the user
 * Performs all the necessary functions like incrementing task index and retrieving tasks
 * Includes the funcitons that require querying of the taskList
 */
public class TaskList {

    private static ArrayList<Task> taskList;
    private static int currentTaskIndex;

    /**
     * Constructor
     * Used when no prior save data is found.
     */
    public TaskList() {
        taskList = new ArrayList<>();
        currentTaskIndex = 0;
    }

    /**
     * Overloading the constructor
     *
     * @param tasks which is an arraylist of saved tasks
     */
    public TaskList(ArrayList<Task> tasks) {
        taskList = tasks;
        currentTaskIndex = taskList.size();
    }

    public static int getTaskIndex() {
        return currentTaskIndex;
    }

    public static void incrementIndex() {
        currentTaskIndex += 1;
    }

    public static void decrementIndex() {
        currentTaskIndex -= 1;
    }

    public static ArrayList<Task> getTaskList() {
        return taskList;
    }

    public static int getNumTasks() {
        return taskList.size();
    }

    /**
     * Marks the task referenced by the taskNum as completed.
     *
     * @param taskNum the task which is to be marked as completed
     */
    public static void completeTask(int taskNum) {
        taskList.get(taskNum).MarkDone();
    }

    /**
     * Deletes the current task from the taskList
     * Expects the target index or taskNum to be found beforehand.
     *
     * @param targetTaskNum the index of task to be deleted
     */
    public static void deleteTask(int targetTaskNum) {
        taskList.remove(queryTask(targetTaskNum));
    }

    /**
     * Returns the Task object at the taskIndex specified
     *
     * @param taskIndex
     * @return Task object
     */
    public static Task queryTask(int taskIndex) {
        return taskList.get(taskIndex);
    }

    /**
     * Query the latest task that has been added to the taskList
     * Used mainly for printing out responses after commands by the user
     *
     * @return Task object
     */
    public static Task queryLatestTask() {
        return taskList.get(currentTaskIndex);
    }

    public static void insertTask(Task inputTask) {
        taskList.add(inputTask);
    }

    /**
     * Finds all the tasks with the searchString inside the taskList
     *
     * @param searchString
     * @return ArrayList<Task> which contains the searchString
     */
    public static ArrayList<Task> findTasks(String searchString) {
        ArrayList<Task> taskResults = new ArrayList<>();
        for (Task currentTask : taskList) {
            if (currentTask.getDescription().contains(searchString)) {
                taskResults.add(currentTask);
            }
        }
        return taskResults;
    }

    /**
     * Queries taskList for all tasks after (exclusive) the specified searchDate
     *
     * @param searchedDate
     * @return ArrayList of tasks that have dates in the description after searchedDate or empty list if none found
     * @throws NullPointerException if input date format is wrong
     */
    public static ArrayList<Task> getTasksAfterDate(String searchedDate) throws NullPointerException {
        ArrayList<Task> taskResults = new ArrayList<>();
        LocalDate targetDate = findDate(searchedDate);
        if (targetDate == null) {
            throw new NullPointerException();
        }
        for (Task currentTask : taskList) {
            LocalDate taskDate = findDate(currentTask.toString());
            if (taskDate != null && taskDate.isAfter(targetDate)) {
                taskResults.add(currentTask);
            }
        }
        return taskResults;
    }

    /**
     * Queries taskList for all tasks before (exclusive) the specified searchDate
     *
     * @param searchedDate
     * @return ArrayList of tasks that have dates in the description after searchedDate or empty list if none found
     * @throws NullPointerException if input date format is wrong
     */
    public static ArrayList<Task> getTasksBeforeDate(String searchedDate) throws NullPointerException {
        ArrayList<Task> taskResults = new ArrayList<>();
        LocalDate targetDate = findDate(searchedDate);
        if (targetDate == null) {
            throw new NullPointerException();
        }
        for (Task currentTask : taskList) {
            LocalDate taskDate = findDate(currentTask.toString());
            if (taskDate != null && taskDate.isBefore(targetDate)) {
                taskResults.add(currentTask);
            }
        }
        return taskResults;
    }

    /**
     * Queries taskList for all tasks on the specified searchDate
     *
     * @param searchedDate
     * @return ArrayList of tasks that have dates in the description after searchedDate or emptylist if none found
     * @throws NullPointerException if input date format is wrong
     */
    public static ArrayList<Task> getTasksOnDate(String searchedDate) throws NullPointerException {
        ArrayList<Task> taskResults = new ArrayList<>();
        LocalDate targetDate = findDate(searchedDate);
        if (targetDate == null) {
            throw new NullPointerException();
        }
        for (Task currentTask : taskList) {
            LocalDate taskDate = findDate(currentTask.toString());
            if (taskDate != null && taskDate.isEqual(targetDate)) {
                taskResults.add(currentTask);
            }
        }
        return taskResults;
    }

    /**
     * Queries taskList for all tasks after (exclusive) the specified searchTime
     *
     * @param searchedTime
     * @return ArrayList of tasks that have dates in the description after searchedTime or emptylist if none found
     * @throws NullPointerException if input date format is wrong
     */
    public static ArrayList<Task> getTasksAfterTime(String searchedTime) throws NullPointerException {
        ArrayList<Task> taskResults = new ArrayList<>();
        LocalTime targetTime = findTime(searchedTime);
        if (targetTime == null) {
            throw new NullPointerException();
        }
        for (Task currentTask : taskList) {
            LocalTime taskTime = findTime(currentTask.toString());
            if (taskTime != null && taskTime.isAfter(targetTime)) {
                taskResults.add(currentTask);
            }
        }
        return taskResults;
    }

    /**
     * Queries taskList for all tasks before (exclusive) the specified searchTime
     *
     * @param searchedTime
     * @return ArrayList of tasks that have dates in the description after searchedTime or emptylist if none found
     * @throws NullPointerException if input date format is wrong
     */
    public static ArrayList<Task> getTasksBeforeTime(String searchedTime) throws NullPointerException {
        ArrayList<Task> taskResults = new ArrayList<>();
        LocalTime targetTime = findTime(searchedTime);
        if (targetTime == null) {
            throw new NullPointerException();
        }
        for (Task currentTask : taskList) {
            LocalTime taskTime = findTime(currentTask.toString());
            if (taskTime != null && taskTime.isBefore(targetTime)) {
                taskResults.add(currentTask);
            }
        }
        return taskResults;
    }

    /**
     * Queries taskList for all tasks at the specified searchTime
     *
     * @param searchedTime
     * @return ArrayList of tasks that have dates in the description after searchedTime or emptylist if none found
     * @throws NullPointerException if input date format is wrong
     */
    public static ArrayList<Task> getTasksOnTime(String searchedTime) throws NullPointerException {
        ArrayList<Task> taskResults = new ArrayList<>();
        LocalTime targetTime = findTime(searchedTime);
        if (targetTime == null) {
            throw new NullPointerException();
        }
        for (Task currentTask : taskList) {
            LocalTime taskTime = findTime(currentTask.toString());
            if (taskTime != null && taskTime.equals(targetTime)) {
                taskResults.add(currentTask);
            }
        }
        return taskResults;
    }

    /**
     * Returns any date in the format of 'YYYY-MM-DD' found in the inputString using regex
     * If none found, null is returned
     *
     * @param inputString
     * @return LocalDate, date found in string
     */
    public static LocalDate findDate(String inputString) {
        Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");  //Extracts in the form yyyy-mm-dd
        Matcher matcher = pattern.matcher(inputString);
        LocalDate date = null;
        try {
            if (matcher.find()) {
                date = LocalDate.parse(matcher.group());
            }
        } catch (Exception e) {
            date = null;
        }
        return date;
    }

    /**
     * Returns any time in the format of 'HH:MM' found in the inputString using regex
     * If none found, null is returned
     *
     * @param inputString
     * @return LocalTime, time found in string
     */
    public static LocalTime findTime(String inputString) {
        LocalTime time = null;
        Pattern pattern = Pattern.compile("\\d{2}:\\d{2}"); //Extracts time in the format HH:MM
        Matcher matcher = pattern.matcher(inputString);
        try {
            if (matcher.find()) {
                time = LocalTime.parse(matcher.group());
            }
        } catch (Exception e) {
            time = null;
        }
        return time;
    }

}
