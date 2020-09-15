import EntryItems.Task;

public class Deadline extends Task {
    String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String saveValue() {
        String result;
        if (this.isDone) {
            result =  "E|1|";
        } else {
            result =  "E|0|";
        }
        result  += (this.taskName + "|" + this.by);
        return result;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
