package Commands;

import EntryItems.Task;
import Utility.TaskList;
import Utility.Ui;

import java.util.ArrayList;

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

    @Override
    public void process() {
        try {
            switch (cmd) {
            case "before":
                timeSearchResults = TaskList.getEventsBeforeTime(searchTime);
                break;
            case "after":
                timeSearchResults = TaskList.getEventsAfterTime(searchTime);
                break;
            case "on":
                timeSearchResults = TaskList.getEventsOnTime(searchTime);
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
