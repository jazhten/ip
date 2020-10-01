package Commands;

import Utility.Storage;
import Utility.TaskList;
import Utility.Ui;

/**
 * Handles the `done` command
 */
public class DoneCommand extends Command {
    int index;

    public DoneCommand(String input) {
        super(input);
        this.index = Integer.parseInt(input.split(" ")[1]) - 1;

    }

    /**
     * Marks the task specified at the index as done.
     * Calls ui functions that responds to the user
     */
    public void process() {
        try {
            TaskList.completeTask(index);
        } catch (NullPointerException e) {
            Ui.printTaskIndexErrorException();
            return;
        }
        Ui.completeTask(TaskList.getTaskList(), index);
        Storage.saveData(TaskList.getTaskList());
    }
}
