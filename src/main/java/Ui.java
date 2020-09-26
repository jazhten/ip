import EntryItems.Task;

import java.util.ArrayList;

public class Ui {

    void startUpDuke() {
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

    /**
     * Function to print response when new tasks are added to the list
     **/
    public static void printAddResponse(Task task, int index) {
        System.out.println("\tGot it. I've added this task:");
        System.out.println("\t" + task.toString());
        System.out.println("\tNow you have " + index + " tasks in the list");
    }

    /**
     * Prints all tasks in the list with the letter heading [D],[E] and status of completion.
     **/
    public static void printList(ArrayList<Task> tasks, int taskIndex) {
        if (taskIndex > 0) {
            System.out.println("\tHere are the tasks in your list:");
            for (int i = 0; i < taskIndex; i++) {
                System.out.println("\t" + (i + 1) + ". " + tasks.get(i).toString());
            }
        } else {
            System.out.println("\tHey there young Padawan, your list seems to be empty!");
        }
    }

    public static void printSearchedList(ArrayList<Task> tasks, int taskIndex) {
        System.out.println("\tHere are tasks matching the description we found in your list:");
        for (int i = 0; i < taskIndex; i++) {
            System.out.println("\t" + (i + 1) + ". " + tasks.get(i).toString());
        }
    }

    /**
     * Function to print the response when a task is marked as completed by the user.
     **/
    public static void completeTask(ArrayList<Task> tasks, int taskIndex) {
        System.out.println("\tNice! I've marked this task as done: ");
        System.out.println("\t  " + tasks.get(taskIndex).toString());
    }

    public static void deleteTask(Task tasks, int numTaskRemaining) {
        System.out.println("\tHmmm removed this task, I have:");
        System.out.println("\t  " + tasks.toString());
        System.out.println("\t Only " + numTaskRemaining + " tasks remain...");
    }

    public static void printIOException() {
        System.out.println(DukeException.ExceptionResponse.EXCEPTION_IO_EXCEPTION);
    }

    public static void printBasicDukeException(DukeException e) {
        System.out.println(e.getMessage());
    }

    public static void printUnknownInputException() {
        System.out.println(DukeException.ExceptionResponse.EXCEPTION_UNIDENTIFIED_INPUT);
    }

    public static void printTaskIndexErrorException() {
        System.out.println(DukeException.ExceptionResponse.EXCEPTION_COMPLETE_UNDEFINED_TASK);
    }

    public static void printNotFoundException() {
        System.out.println(DukeException.ExceptionResponse.EXCEPTION_NOT_FOUND_EXCEPTION);
    }

    public static void endProgram() {
        System.out.println("Bye. May the Force be with you.");

    }


}
