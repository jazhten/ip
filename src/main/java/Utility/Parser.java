package Utility;

import Commands.*;


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
        String cmd = input.split(" ")[0];
        
        switch (cmd) {

        case "list":
            Command.listCommand();
            return;

        case "bye":
            Ui.endProgram();
            this.isExit = true;
            return;

        case "done":
            DoneCommand doneCmd = new DoneCommand(input);
            doneCmd.process();
            return;

        case "delete":
            DeleteCommand deleteCmd = new DeleteCommand(input);
            deleteCmd.process();
            return;

        case "todo":
            TodoCommand todoCmd = new TodoCommand(input);
            todoCmd.process();
            return;

        case "date":
            DateCommand dateCmd = new DateCommand(input);
            if (dateCmd.isValidInput) {
                dateCmd.process();
            }
            return;

        case "time":
            TimeCommand timeCmd = new TimeCommand(input);
            if (timeCmd.isValidInput) {
                timeCmd.process();
            }
            return;

        case "find":
            FindCommand findCmd = new FindCommand(input);
            findCmd.process();
            return;

        case "deadline":
            DeadlineCommand deadlineCmd = new DeadlineCommand(input);
            deadlineCmd.process();
            return;

        case "event":
            EventCommand eventCmd = new EventCommand(input);
            eventCmd.process();
            return;

        case "":
            Ui.printUnknownInputException();
            return;

        default:
            Ui.printUnknownInputException();
        }
    }
}
