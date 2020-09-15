import EntryItems.Task;
import java.util.ArrayList;

public class StringOperations {

    /*
    Params : input
     */
    public static int getFirstSpace(String input) throws DukeException {
        int index = input.indexOf(" ");
        if (index == -1) {
            throw new DukeException(DukeException.ExceptionResponse.EXCEPTION_NO_DESCRIPTION);
        }
        return index;
    }

    /*
    Function to print response when new tasks are added to the list
     */
    public static void printAddResponse(Task task, int index) {
        System.out.println("\tGot it. I've added this task:");
        System.out.println("\t" + task.toString());
        System.out.println("\tNow you have " + index + " tasks in the list");
    }

    /*
    Prints all tasks in the list with the letter heading [D],[E] and status of completion.
     */
    public static void printList(ArrayList<Task> tasks, int taskIndex) {
        System.out.println("\tHere are the tasks in your list:");
        for (int i = 0; i < taskIndex; i++) {
            System.out.println("\t" + (i + 1) + ". " + tasks.get(i).toString());
        }
    }

    /*
    Function to print the response when a task is marked as completed by the user.
     */
    public static void completeTask(ArrayList<Task> tasks, int taskIndex) {
        System.out.println("\tNice! I've marked this task as done: ");
        System.out.println("\t  " + tasks.get(taskIndex).toString());
    }

    public static void deleteTask(Task tasks, int numTaskRemaining) {
        System.out.println("\tHmmm removed this task, I have:");
        System.out.println("\t  " + tasks.toString());
        System.out.println(String.format("\t Only %d tasks remain...",numTaskRemaining));
    }

    /*
    Function to find the starting index of the description in events/deadlines where they
    the start of the timing details are denoted by a "/"
     */
    public static String getDescription(String input) {
        int startPoint = input.indexOf("/");
        String output = "";
        try {
            output = input.substring(getFirstSpace(input), startPoint);
            return output;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /*
    Function to return the deadline, found after "/by" or "/at"
        -assumes "/by" and "/at" only occurs once in the start of the deadline
     */
    public static String getTimeline(String input, String taskType) throws DukeException {
        String searchString = "";
        if (taskType.equals("event")) {
            searchString = "/at";
        } else if (taskType.equals("deadline")) {
            searchString = "/by";
        }
        int startPoint = input.indexOf(searchString);
        if (startPoint == -1) {
            throw new DukeException(DukeException.ExceptionResponse.EXCEPTION_NO_FORMAT_IDENTIFIER);
        }
        String fullDeadline = input.substring(startPoint);
        fullDeadline = fullDeadline.replace(searchString, "");
        if (fullDeadline.isBlank()) {
            throw new DukeException(DukeException.ExceptionResponse.EXCEPTION_NO_TIME_DATA);
        }
        return fullDeadline.trim();
    }

    public static void printIntroduction() {
        final String YODA_LOGO = "                    .==.\n" +
                "                   ()''()-.\n" +
                "        .---.       ;--; /\n" +
                "      .'_:___\". _..'.  __'.\n" +
                "      |__ --==|'-''' \\'...;\n" +
                "      [  ]  :[|       |---\\\n" +
                "      |__| I=[|     .'    '.\n" +
                "      / / ____|     :       '._\n" +
                "     |-/.____.'      | :       :\n" +
                "    /___\\ /___\\      '-'._----'";
        System.out.println(YODA_LOGO);
        System.out.println("Hello there General Kenobi. You are our last hope.");
    }
}
