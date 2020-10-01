package Commands;

import EntryItems.Todo;
import Utility.*;

public class TodoCommand extends Command {
    String description;

    public TodoCommand(String input) {
        super(input);
        description = "";
    }

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
