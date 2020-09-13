public class InputManager {
    private boolean isExit;
    private int currentTaskIndex;
    protected Task[] storedTasks;

    public InputManager(int size) {
        this.isExit = false;
        this.currentTaskIndex = 0;
        storedTasks = new Task[size];
    }

    public boolean getTerminationStatus() {
        return isExit;
    }

    public void handleInput(String input) {
        String[] splitInput = input.split(" ");
        String cmd = splitInput[0];
        switch (cmd) {

        case "list":
            StringOperations.printList(storedTasks, currentTaskIndex);
            return;

        case "bye":
            System.out.println("Bye. May the Force be with you.");
            this.isExit = true;
            return;

        case "done":
            int taskNum = Integer.parseInt(splitInput[1]) - 1;
            try {
                storedTasks[taskNum].MarkDone();
            } catch (NullPointerException e) {
                System.out.println(DukeException.ExceptionResponse.EXCEPTION_COMPLETE_UNDEFINED_TASK);
                return;
            }
            StringOperations.completeTask(storedTasks, taskNum);
            return;

        case "todo":
            String description;
            try {
                description = input.substring(StringOperations.getFirstSpace(input));
            } catch (DukeException e) {
                System.out.println(e.getMessage());
                return;
            }
            storedTasks[currentTaskIndex] = new Todo(description);
            StringOperations.printAddResponse(storedTasks[currentTaskIndex], currentTaskIndex + 1);
            this.currentTaskIndex += 1;
            return;

        case "deadline":
            String deadlineOperation;
            try {
                deadlineOperation = StringOperations.getTimeline(input, cmd);
            } catch (DukeException e) {
                System.out.println(e.getMessage());
                return;
            }
            String deadlineInputDescription = StringOperations.getDescription(input);
            storedTasks[currentTaskIndex] = new Deadline(deadlineInputDescription, deadlineOperation);
            StringOperations.printAddResponse(storedTasks[currentTaskIndex], currentTaskIndex + 1);
            this.currentTaskIndex += 1;
            return;

        case "event":
            String eventOperation;
            try {
                eventOperation = StringOperations.getTimeline(input, cmd);
            } catch (DukeException e) {
                System.out.println(e.getMessage());
                return;
            }
            String eventInputDescription = StringOperations.getDescription(input);
            storedTasks[currentTaskIndex] = new Event(eventInputDescription, eventOperation);
            StringOperations.printAddResponse(storedTasks[currentTaskIndex], currentTaskIndex + 1);
            this.currentTaskIndex += 1;
            return;
            
        case "":
            System.out.println(DukeException.ExceptionResponse.EXCEPTION_UNIDENTIFIED_INPUT);
            return;

        default:
            System.out.println(DukeException.ExceptionResponse.EXCEPTION_UNIDENTIFIED_INPUT);
        }
    }
}
