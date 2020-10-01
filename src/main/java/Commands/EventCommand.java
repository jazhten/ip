package Commands;

import EntryItems.Event;
import Utility.*;

public class EventCommand extends Command {

    String eventOperation;
    String cmd;

    public EventCommand(String input) {
        super(input);
        cmd = input.split(" ")[0];
    }

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
