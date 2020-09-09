public class Task {
    private final String taskName;
    private boolean isDone;

    public Task(String description) {
        this.taskName = description;
        this.isDone = false;
    }

    public void MarkDone() {
        this.isDone = true;
    }

    @Override
    public String toString() {
        return ((isDone ? "[\u2713] " : "[\u2718] ") + taskName);
    }
}
