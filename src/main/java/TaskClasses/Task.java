package TaskClasses;

/**
 * Parent class of all the various tasks Duke handles
 * Describes teh various names and status of the tasks
 * Provides the basic toString() and saveValue() methods which wil be overwritten in the children classes
 */
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

    public void MarkDone() {
        this.isDone = true;
    }

    public String getDescription() {
        return taskName;
    }

    @Override
    public String toString() {
        return ((isDone ? "[\u2713] " : "[\u2718] ") + taskName);
    }
}
