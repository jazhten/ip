package EntryItems;

public class Task {
    protected final String taskName;
    protected boolean isDone;

    public Task(String description) {
        this.taskName = description;
        this.isDone = false;
    }


    public String saveValue() {
        return "";
    }
    public String getDescription() {
        return taskName;
    }
    public void MarkDone() {
        this.isDone = true;
    }


    @Override
    public String toString() {
        return ((isDone ? "[\u2713] " : "[\u2718] ") + taskName);
    }
}
