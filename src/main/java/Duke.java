import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Duke, the friendly ChatBot that handles your tasks.
 */
public class Duke {

    private final Storage storage;
    private TaskList taskList;
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
            System.out.print("\u2658 : ");
            parseManager.handleInput(inputScanner.nextLine());
        }
    }

    /**
     * Inits Ui and storage objects
     *
     * @param filePath which is where the save data is loaded on disk
     */
    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            taskList = new TaskList(storage.loadSaveFile());
        } catch (FileNotFoundException e) {
            taskList = new TaskList();
        }
    }
}