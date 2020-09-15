public class Event extends Task {
    String timeFrame;

    public Event(String description, String timeFrame) {
        super(description);
        this.timeFrame = timeFrame;
    }

    @Override
    public String saveValue() {
        String result;
        if (this.isDone) {
            result =  "E|1|";
        } else {
            result =  "E|0|";
        }
        result  += (this.taskName + "|" + this.timeFrame);
        return result;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + timeFrame + ")";
    }
}
