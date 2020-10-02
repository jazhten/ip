package Commands;

import Utility.TaskList;
import Utility.Ui;

/**
 * Parent class of the commands
 * Handles basic commands (like list) which does not require state
 */
public class Command {
    protected String input;

    public Command(String input) {
        this.input = input;
    }

    /**
     * Overwritten in the individual commands
     */
    public void process() {
        return;
    }

    /**
     * Prints all the tasks in the taskList
     */
    public static void listCommand() {
        Ui.printList(TaskList.getTaskList(), TaskList.getTaskIndex());
    }

    /**
     * Displays the help menu
     */
    public static void helpCommand() {
        Ui.printHelpList();
    }
}
