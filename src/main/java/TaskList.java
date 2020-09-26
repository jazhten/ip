import EntryItems.Task;

import java.util.ArrayList;

/**
 * The list of tasks that are currently assigned to the user
 * Performs all the necessary functions like incrementing task index and retrieving tasks
 */
public class TaskList {

    private static ArrayList<Task> taskList;
    private static int currentTaskIndex;

    /**
     * Constructor
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

    public static Task queryTask(int taskIndex) {
        return taskList.get(taskIndex);
    }

    public static Task queryLatestTask() {
        return taskList.get(currentTaskIndex);
    }

    public static void insertTask(Task inputTask) {
        taskList.add(inputTask);
    }
}
