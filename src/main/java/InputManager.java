<<<<<<< HEAD
import EntryItems.Event;
import EntryItems.Task;
import EntryItems.Todo;
import java.util.ArrayList;
=======
import java.io.FileNotFoundException;
>>>>>>> branch-Level-7

public class InputManager {
    protected boolean isExit;
    protected int currentTaskIndex;
    protected static ArrayList<Task> storedTasks;

    public InputManager() {
        this.isExit = false;
        this.currentTaskIndex = 0;
<<<<<<< HEAD
        storedTasks = new ArrayList<Task>();
=======
        try {
            storedTasks = SaveFile.loadSaveFile(size);
        } catch (FileNotFoundException e) {
            storedTasks = new Task[size];
        }
        this.currentTaskIndex = 3; //replace with .size() when its an array list
>>>>>>> branch-Level-7
    }

    public boolean getTerminationStatus() {
        return isExit;
    }

    public void handleInput(String input) {
        String[] splitInput = input.split(" ");
        String cmd = splitInput[0];
        switch (cmd) {

        case "list":
            StringOperations.printList(storedTasks, currentTaskIndex);
            return;

        case "bye":
            System.out.println("Bye. May the Force be with you.");
            this.isExit = true;
            return;

        case "done":
            int taskNum = Integer.parseInt(splitInput[1]) - 1;
            try {
                storedTasks.get(taskNum).MarkDone();
            } catch (NullPointerException e) {
                System.out.println(DukeException.ExceptionResponse.EXCEPTION_COMPLETE_UNDEFINED_TASK);
                return;
            }
            StringOperations.completeTask(storedTasks, taskNum);
            SaveFile.saveData(storedTasks,currentTaskIndex);
            return;

        case "delete":
            Task targetTask;
            int delTargetNum = Integer.parseInt(splitInput[1]) - 1;
            try {
                targetTask = storedTasks.get(Integer.valueOf(delTargetNum));
                storedTasks.remove(targetTask);
                currentTaskIndex -= 1;
            } catch (Exception e) {
                System.out.println(DukeException.ExceptionResponse.EXCEPTION_COMPLETE_UNDEFINED_TASK);
                return;
            }
            StringOperations.deleteTask(targetTask, storedTasks.size());
            return;

        case "todo":
            String description;
            try {
                description = input.substring(StringOperations.getFirstSpace(input));
            } catch (DukeException e) {
                System.out.println(e.getMessage());
                return;
            }
            storedTasks.add(new Todo(description));
            StringOperations.printAddResponse(storedTasks.get(currentTaskIndex), currentTaskIndex + 1);
            this.currentTaskIndex += 1;
            SaveFile.saveData(storedTasks,currentTaskIndex);
            return;

        case "deadline":
            String deadlineOperation;
            try {
                deadlineOperation = StringOperations.getTimeline(input, cmd);
            } catch (DukeException e) {
                System.out.println(e.getMessage());
                return;
            }
            String deadlineInputDescription = StringOperations.getDescription(input);
            storedTasks.add(new Deadline(deadlineInputDescription, deadlineOperation));
            StringOperations.printAddResponse(storedTasks.get(currentTaskIndex), currentTaskIndex + 1);
            this.currentTaskIndex += 1;
            SaveFile.saveData(storedTasks,currentTaskIndex);
            return;

        case "event":
            String eventOperation;
            try {
                eventOperation = StringOperations.getTimeline(input, cmd);
            } catch (DukeException e) {
                System.out.println(e.getMessage());
                return;
            }
            String eventInputDescription = StringOperations.getDescription(input);
            storedTasks.add(new Event(eventInputDescription, eventOperation));
            StringOperations.printAddResponse(storedTasks.get(currentTaskIndex), currentTaskIndex + 1);
            this.currentTaskIndex += 1;
            SaveFile.saveData(storedTasks,currentTaskIndex);
            return;

        case "":
            System.out.println(DukeException.ExceptionResponse.EXCEPTION_UNIDENTIFIED_INPUT);
            return;

        default:
            System.out.println(DukeException.ExceptionResponse.EXCEPTION_UNIDENTIFIED_INPUT);
        }
    }
}
