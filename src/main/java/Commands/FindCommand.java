package Commands;

import EntryItems.Task;
import Utility.DukeException;
import Utility.StringOperations;
import Utility.TaskList;
import Utility.Ui;

import java.util.ArrayList;

public class FindCommand extends Command {

    String searchString;
    int numResults;

    public FindCommand(String input) {
        super(input);
        numResults = 0;
    }

    @Override
    public void process() {
        try {
            searchString = input.substring(StringOperations.getFirstSpace(input));
        } catch (DukeException e) {
            Ui.printBasicDukeException(e);
            return;
        }
        ArrayList<Task> searchResults;
        searchResults = TaskList.findTasks(searchString);
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
    }
}
