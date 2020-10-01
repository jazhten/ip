package Commands;

import TaskClasses.Deadline;
import Utility.*;

/**
 * Handles `deadline` command
 */
public class DeadlineCommand extends Command {

    String deadlineOperation;
    String cmd;

    public DeadlineCommand(String input) {
        super(input);
        cmd = input.split(" ")[0];
    }

    /**
     * Processes the deadline to be added to the tasklist
     * Adds deadline to the taskList
     * Prints responses to the user
     */
    @Override
    public void process() {
        try {
            deadlineOperation = StringOperations.getTimeline(input, cmd);
        } catch (DukeException e) {
            Ui.printBasicDukeException(e);
            return;
        }
        String deadlineInputDescription = StringOperations.getDescription(input);
        TaskList.insertTask(new Deadline(deadlineInputDescription, deadlineOperation));
        Ui.printAddResponse(TaskList.queryLatestTask(),
                TaskList.getTaskIndex() + 1);
        TaskList.incrementIndex();
        Storage.saveData(TaskList.getTaskList());
    }
}
