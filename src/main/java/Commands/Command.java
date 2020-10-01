package Commands;

import Utility.TaskList;
import Utility.Ui;

public class Command {
    protected String input;

    public Command(String input) {
        this.input = input;
    }

    public void process() {
        return;
    }

    public static void listCommand() {
        Ui.printList(TaskList.getTaskList(), TaskList.getTaskIndex());
    }
}
