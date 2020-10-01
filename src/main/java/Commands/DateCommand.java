package Commands;

import TaskClasses.Task;
import Utility.TaskList;
import Utility.Ui;

import java.util.ArrayList;

/**
 * Date command. Used to find tasks {before/on/after} the date searched
 * input format : `date {before/on/after} 1900-01-01`
 */
public class DateCommand extends Command {
    String searchDate;
    String cmd;
    ArrayList<Task> dateSearchResults;
    public boolean isValidInput;
    int numDateResults;

    public DateCommand(String input) {
        super(input);
        numDateResults = 0;
        extractCommand();
    }

    /**
     * Extracts the command {before/on/after} and the searchedDate
     * Also verifies if the input is valid before allowing the process() to run
     */
    private void extractCommand() {
        try {
            String[] splitInput = input.split(" ");
            cmd = splitInput[1];
            searchDate = splitInput[2];
            isValidInput = true;
        } catch (NullPointerException e) {
            Ui.printInvalidInputDateException();
            isValidInput = false;
        } catch (ArrayIndexOutOfBoundsException e) {
            isValidInput = false;
            Ui.printInvalidDateInputFormatException();
        }
    }

    /**
     *  Search for the tasks with date {before/on/after} the input date
     */
    @Override
    public void process() {
        try {
            switch (cmd) {
            case "before":
                dateSearchResults = TaskList.getTasksBeforeDate(searchDate);
                break;
            case "after":
                dateSearchResults = TaskList.getTasksAfterDate(searchDate);
                break;
            case "on":
                dateSearchResults = TaskList.getTasksOnDate(searchDate);
                break;
            }
        } catch (NullPointerException e) {
            Ui.printInvalidInputDateException();
            return;
        }
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
    }

}
