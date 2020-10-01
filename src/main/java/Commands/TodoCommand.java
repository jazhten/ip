package Commands;

import TaskClasses.Todo;
import Utility.*;

/**
 * Handles `todo` command
 */
public class TodoCommand extends Command {
    String description;

    public TodoCommand(String input) {
        super(input);
        description = "";
    }

    /**
     * Processes the todo to be added to the tasklist
     * Adds todo to the taskList
     * Prints responses to the user
     */
    @Override
    public void process() {
        try {
            description = input.substring(StringOperations.getFirstSpace(input));
        } catch (DukeException e) {
            Ui.printBasicDukeException(e);
            return;
        }
        TaskList.insertTask(new Todo(description));
        Ui.printAddResponse(TaskList.queryLatestTask(),
                TaskList.getTaskIndex() + 1);
        TaskList.incrementIndex();
        Storage.saveData(TaskList.getTaskList());
    }
}
