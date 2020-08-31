public class Task {
    private final String taskName;
    private boolean isDone;

    public Task(String description){
        this.taskName = description;
        this.isDone = false;
    }

    public void completeTask(){
        this.isDone = true;
    }
/*
    public String getTaskName(){
        return taskName;
    }*/

    public String getTaskInfo(){
        return ((isDone ? "[\u2713] " : "[\u2718] ") + taskName);
    }
    @Override
    public String toString(){
        return ((isDone ? "[\u2713] " : "[\u2718] ") + taskName);
    }
}