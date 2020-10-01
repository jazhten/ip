package Commands;

import EntryItems.Task;
import Utility.Storage;
import Utility.TaskList;
import Utility.Ui;

public class DeleteCommand extends Command {
    int index;

    public DeleteCommand(String input) {
        super(input);
        this.index = Integer.parseInt(input.split(" ")[1]) - 1;
    }

    public void process() {
        Task targetTask;
        try {
            targetTask = TaskList.queryTask(index);
            TaskList.deleteTask(index);
            TaskList.decrementIndex();
        } catch (Exception e) {
            Ui.printTaskIndexErrorException();
            return;
        }
        Ui.deleteTask(targetTask, TaskList.getNumTasks());
        Storage.saveData(TaskList.getTaskList());
    }
}
