public class DukeException extends Exception {

    public enum ExceptionResponse {
        EXCEPTION_NO_DESCRIPTION("\tMissed the Description you have, young padawan..."),
        EXCEPTION_NO_TIME_DATA("\tOopsies! Mesa thinksa yousa missed the time"),//jar jar binks btw
        EXCEPTION_NO_FORMAT_IDENTIFIER("\tThe force requires you provide the correct identifier (/by /at)."),
        EXCEPTION_COMPLETE_UNDEFINED_TASK("\tToo hasty you are, the task has not been defined yet"),
        EXCEPTION_UNIDENTIFIED_INPUT("\tThese are not the inputs you are looking for...Please input something");

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
