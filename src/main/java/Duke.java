import EntryItems.Task;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    private Storage storage;
    private TaskList taskList;
    private Ui ui;

    public static void main(String[] args) {
     new Duke("data/Duke.txt").run();
    }

    public void run(){
        ui.startUpDuke();
        Scanner inputScanner = new Scanner(System.in);
        Parser parseManager = new Parser();
        while (!parseManager.getTerminationStatus()) {
            System.out.print("\u2658 : ");
            parseManager.handleInput(inputScanner.nextLine());
        }
    }

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