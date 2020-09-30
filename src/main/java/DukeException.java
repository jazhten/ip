/**
 * Handles the various exceptions which may be encountered during the program's lifetime.
 * Some are slightly unnecessary but were included for the 'personality' of the Duke Bot
 */
public class DukeException extends Exception {

    public enum ExceptionResponse {
        EXCEPTION_NO_DESCRIPTION("\tMissed the Description you have, young padawan..."),
        EXCEPTION_NO_TIME_DATA("\tOopsies! Mesa thinksa yousa missed the time"),
        EXCEPTION_NO_FORMAT_IDENTIFIER("\tThe force requires you provide the correct identifier (/by /at)."),
        EXCEPTION_COMPLETE_UNDEFINED_TASK("\tToo hasty you are, the task has not been defined yet"),
        EXCEPTION_UNIDENTIFIED_INPUT("\tThese are not the inputs you are looking for...Please input something"),
        EXCEPTION_IO_EXCEPTION("\tHmmm, it seems there has been an IO Error, why don't you give it another try"),
        EXCEPTION_INVALID_SEARCH_DATE("\tWhen is that???!!! Please put in a proper date in the format : 'yyyy-mm-dd'"),
        EXCEPTION_INVALID_SEARCH_TIME("\tWhat time already gennermen?! Please input a proper time format HH:MM'"),
        EXCEPTION_NOT_FOUND_EXCEPTION("\tHey buddy, it seems like we don't have what you're looking for!");
        private String exception;

        ExceptionResponse(String exceptionMessage) {
            this.exception = exceptionMessage;
        }

        @Override
        public String toString() {
            return exception;
        }
    }

    public DukeException(ExceptionResponse exception) {
        super(exception.toString());
    }
}
