package Commands;

import TaskClasses.Event;
import Utility.*;

public class EventCommand extends Command {

    String eventOperation;
    String cmd;

    /**
     * Handles `event` command
     */
    public EventCommand(String input) {
        super(input);
        cmd = input.split(" ")[0];
    }

    /**
     * Processes the event to be added to the tasklist
     * Adds event to the taskList
     * Prints responses to the user
     */
    @Override
    public void process() {
        try {
            eventOperation = StringOperations.getTimeline(input, cmd);
        } catch (DukeException e) {
            Ui.printBasicDukeException(e);
            return;
        }
        String eventInputDescription = StringOperations.getDescription(input);
        TaskList.insertTask(new Event(eventInputDescription, eventOperation));
        Ui.printAddResponse(TaskList.queryLatestTask(),
                TaskList.getTaskIndex() + 1);
        TaskList.incrementIndex();
        Storage.saveData(TaskList.getTaskList());
    }
}
