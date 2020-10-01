package EntryItems;

/**
 * Describes the properties of the deadline
 * Able to override the toString() method to return a more informative description
 */
public class Deadline extends Task {
    String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Ensures the data for Deadlines are saved correctly
     * Important as the save file loader uses regex and chars must be in the right place
     *
     * @return Formatted description of deadline for saving
     */
    @Override
    public String saveValue() {
        String result;
        if (this.isDone) {
            result = "E|1|";
        } else {
            result = "E|0|";
        }
        result += (this.taskName + "|" + this.by);
        return result;
    }

    /**
     * @return Formatted description of deadline
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
