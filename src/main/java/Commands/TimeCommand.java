package Commands;

import TaskClasses.Task;
import Utility.TaskList;
import Utility.Ui;

import java.util.ArrayList;

/**
 * Time command. Used to find tasks {before/on/after} the time searched
 * input format : `time {before/on/after} 12:25`
 */
public class TimeCommand extends Command {

    private String searchTime;
    private int numTimeResults;
    private String cmd;
    public boolean isValidInput;
    private ArrayList<Task> timeSearchResults;

    public TimeCommand(String input) {
        super(input);
        numTimeResults = 0;
        extractCommand();

    }

    /**
     * Extracts the command {before/on/after} and the searchedTime
     * Also verifies if the input is valid before allowing the process() to run
     */
    private void extractCommand() {
        try {
            String[] splitInput = input.split(" ");
            cmd = splitInput[1];
            searchTime = splitInput[2];
            isValidInput = true;
        } catch (NullPointerException e) {
            Ui.printInvalidInputDateException();
            isValidInput = false;
        } catch (ArrayIndexOutOfBoundsException e) {
            isValidInput = false;
            Ui.printInvalidTimeInputFormatException();
        }
    }

    /**
     *  Search for the tasks with time {before/on/after} the input time
     */
    @Override
    public void process() {
        try {
            switch (cmd) {
            case "before":
                timeSearchResults = TaskList.getTasksBeforeTime(searchTime);
                break;
            case "after":
                timeSearchResults = TaskList.getTasksAfterTime(searchTime);
                break;
            case "on":
                timeSearchResults = TaskList.getTasksOnTime(searchTime);
                break;
            }
        } catch (NullPointerException e) {
            Ui.printInvalidInputTimeException();
            return;
        }
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
    }
}
