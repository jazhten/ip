package Commands;

import EntryItems.Task;
import Utility.TaskList;
import Utility.Ui;

import java.util.ArrayList;


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

    @Override
    public void process() {
        try {
            switch (cmd) {
            case "before":
                dateSearchResults = TaskList.getEventsBeforeDate(searchDate);
                break;
            case "after":
                dateSearchResults = TaskList.getEventsAfterDate(searchDate);
                break;
            case "on":
                dateSearchResults = TaskList.getEventsOnDate(searchDate);
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
