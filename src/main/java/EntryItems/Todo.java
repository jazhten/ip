package EntryItems;

public class Todo extends Task {
    public Todo(String description) {
        super(description);
    }

    @Override
    public String saveValue() {
        String result;
        if (this.isDone) {
            result =  "T|1|";
        } else {
            result =  "T|0|";
        }
        result  += this.taskName;
        return result;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

}
