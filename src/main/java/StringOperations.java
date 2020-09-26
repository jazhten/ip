/**
 * Used to handle the more complicated operations regarding string manipulation
 * Extracted from the parser class for readability
 */
public class StringOperations {

    /**
     * Finds the first occurrence of the space ' ' character in the input string
     *
     * @param input the input by the user
     * @return index of first space
     * @throws DukeException in the case of empty input
     */
    public static int getFirstSpace(String input) throws DukeException {
        int index = input.indexOf(" ");
        if (index == -1) {
            throw new DukeException(DukeException.ExceptionResponse.EXCEPTION_NO_DESCRIPTION);
        }
        return index;
    }


    /**
     * Function to find the starting index of the description in events/deadlines where they
     * the start of the timing details are denoted by a "/"
     *
     * @param input by the user
     * @return String which is the deadline or event time
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


    /**
     * Used to find the timeframe of the current tasks. T
     * This is referenced using the /at or /by identifier
     * Checks for the correct identifier based on the taskType input
     * Searches for the corresponding timeframe
     * Assumes the identifier only is valid on first appearance
     *
     * @param input    by the user in which the 'event' or 'deadline' has been cleaned
     * @param taskType the nature of the tasks, event or deadline etc.
     * @return deadline or timeframe for event
     * @throws DukeException if the format identifier is missing or time data is missing
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
