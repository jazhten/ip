import EntryItems.Event;
import EntryItems.Task;
import EntryItems.Todo;


import java.util.ArrayList;


/**
 * Used to parse all the user input
 * Tracks if the 'bye' command has been sent and sends the signal to Duke to terminate
 */
public class Parser {
    protected boolean isExit;

    public Parser() {
        this.isExit = false;
    }

    public boolean getTerminationStatus() {
        return isExit;
    }

    /**
     * Main 'body' of the chatbot
     * Identifies the nature of the input and passes off the inputs to the various class to handle
     *
     * @param input which is keyed in by the user
     */
    public void handleInput(String input) {
        String[] splitInput = input.split(" ");
        String cmd = splitInput[0];
        switch (cmd) {

        case "list":
            Ui.printList(TaskList.getTaskList(), TaskList.getTaskIndex());
            return;

        case "bye":
            Ui.endProgram();
            this.isExit = true;
            return;

        case "done":
            //finds the target taskNum by getting the integer after the 'done ' identifier
            int taskNum = Integer.parseInt(splitInput[1]) - 1;
            try {
                TaskList.completeTask(taskNum);
            } catch (NullPointerException e) {
                Ui.printTaskIndexErrorException();
                return;
            }
            Ui.completeTask(TaskList.getTaskList(), taskNum);
            Storage.saveData(TaskList.getTaskList());
            return;

        case "delete":
            Task targetTask;
            int delTargetNum = Integer.parseInt(splitInput[1]) - 1;
            try {
                targetTask = TaskList.queryTask(delTargetNum);
                TaskList.deleteTask(delTargetNum);
                TaskList.decrementIndex();
            } catch (Exception e) {
                Ui.printTaskIndexErrorException();
                return;

            }
            Ui.deleteTask(targetTask, TaskList.getNumTasks());
            Storage.saveData(TaskList.getTaskList());
            return;

        case "todo":
            String description;
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
            return;

        case "date":
            String searchDate;
            try {
                searchDate = input.substring(StringOperations.getFirstSpace(input));
            } catch (DukeException e) {
                Ui.printBasicDukeException(e);
                return;
            }
            ArrayList<Task> dateSearchResults;
            try {
                dateSearchResults = TaskList.getEventsAfterDate(searchDate);
            } catch (NullPointerException e) {
                Ui.printInvalidInputDateException();
                return;
            }
            int numDateResults = 0;
            try {
                numDateResults = dateSearchResults.size();
            } catch (NullPointerException e) {
                Ui.printNotFoundException();
            }
            if (numDateResults == 0) {
                Ui.printNotFoundException();
                return;
            }
            Ui.printSearchedList(dateSearchResults, numDateResults);
            return;

        case "time":
            String searchTime;
            try {
                searchTime = input.substring(StringOperations.getFirstSpace(input));
            } catch (DukeException e) {
                Ui.printBasicDukeException(e);
                return;
            }
            ArrayList<Task> timeSearchResults;
            try {
                timeSearchResults = TaskList.getEventsAfterTime(searchTime);
            } catch (NullPointerException e) {
                Ui.printInvalidInputTimeException();
                return;
            }
            int numTimeResults = 0;
            try {
                numTimeResults = timeSearchResults.size();
            } catch (NullPointerException e) {
                Ui.printNotFoundException();
            }
            if (numTimeResults == 0) {
                Ui.printNotFoundException();
                return;
            }
            Ui.printSearchedList(timeSearchResults, numTimeResults);
            return;
            
        case "find":
            String searchString;
            try {
                searchString = input.substring(StringOperations.getFirstSpace(input));
            } catch (DukeException e) {
                Ui.printBasicDukeException(e);
                return;
            }
            ArrayList<Task> searchResults;
            searchResults = TaskList.findTasks(searchString);
            int numResults = 0;
            try {
                numResults = searchResults.size();
            } catch (NullPointerException e) {
                Ui.printNotFoundException();
            }
            if (numResults == 0) {
                Ui.printNotFoundException();
                return;
            }
            Ui.printSearchedList(searchResults, numResults);
            return;
        case "deadline":
            String deadlineOperation;
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
            return;

        case "event":
            String eventOperation;
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
            return;

        case "":
            Ui.printUnknownInputException();
            return;

        default:
            Ui.printUnknownInputException();
        }
    }
}
