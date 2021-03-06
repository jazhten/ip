import Utility.Parser;
import Utility.Storage;
import Utility.TaskList;
import Utility.Ui;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Duke, the friendly ChatBot that handles your tasks.
 */
public class Duke {

    private final Storage storage;
    private final Ui ui;

    public static void main(String[] args) {
        new Duke("data/Duke.txt").run();
    }

    /**
     * Main running body of the program
     * Handles the scanning of input
     * Waits for getTerminationStatus from the parser before ending the program
     */
    public void run() {
        ui.startUpDuke();
        Scanner inputScanner = new Scanner(System.in);
        Parser parseManager = new Parser();
        while (!parseManager.getTerminationStatus()) {
            Ui.printLineIcon();
            parseManager.handleInput(inputScanner.nextLine());
        }
    }

    /**
     * Inits Ui, Storage and taskList objects
     *
     * @param filePath which is where the save data is loaded on disk
     */
    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            new TaskList(storage.loadSaveFile());
        } catch (FileNotFoundException e) {
            new TaskList();
        }
    }
}