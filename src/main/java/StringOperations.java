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
    Function to find the starting index of the description in events/deadlines where they
    the start of the timing details are denoted by a "/"
     */
    public static String getDescription(String input) {
        int startPoint = input.indexOf("/");
        String output;
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

}
