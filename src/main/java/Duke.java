import java.util.Scanner;

public class Duke {

    public static int getFirstSpace(String input){
        return input.indexOf(" ");
    }

    public static void printAddResponse(Task task, int index){
        System.out.println("\tGot it. I've added this task:");
        System.out.println("\t" + task.toString());
        System.out.println("\tNow you have " + index + " tasks in the list");
    }
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello there General Kenobi! I am\n" + logo);
        System.out.println("How may I be at your pleasure today?");
        Scanner sc = new Scanner(System.in);
        Task[] storedTasks = new Task[100];
        int tasksIndex = 0;
        while (true) {
            String input = sc.nextLine();
            String[] splitInput = input.split(" ");
            if(input.equals("list")){
                System.out.println("\tHere are the tasks in your list:");
                for(int i=0;i<tasksIndex;i++){
                    System.out.println("\t"+(i+1) +". "+ storedTasks[i].toString());
                }
            }
            else if (input.equals("bye")) {
                System.out.println("Bye. May the Force be with you.");
                break;
            }
            else if (splitInput[0].equals("done")){
                int taskNum = Integer.parseInt(splitInput[1])-1;
                storedTasks[taskNum].completeTask();
                System.out.println("\tNice! I've marked this task as done: ");
                System.out.println("\t  " + storedTasks[taskNum].toString());
            }
            else if (splitInput[0].equals("todo")){
                //take out the getfirstspace and put it here later
                storedTasks[tasksIndex] = new Todo(input.substring(getFirstSpace(input))); //only take the parts after todo
                printAddResponse(storedTasks[tasksIndex], tasksIndex+1);
                tasksIndex += 1;
            }
            else if (splitInput[0].equals("deadline")){
                int eventDeadlineStart = input.indexOf("/");
                String description = input.substring(getFirstSpace(input),eventDeadlineStart);
                String eventDeadline = input.substring(eventDeadlineStart + 4); //+4 for the by
                storedTasks[tasksIndex] = new Deadline(description,eventDeadline);
                printAddResponse(storedTasks[tasksIndex], tasksIndex+1);
                tasksIndex += 1;
            }
            else if (splitInput[0].equals("event")){
                int eventDeadlineStart = input.indexOf("/");
                String description = input.substring(getFirstSpace(input),eventDeadlineStart);
                String eventDeadline = input.substring(eventDeadlineStart + 4); //+4 for the by
                storedTasks[tasksIndex] = new Event(description,eventDeadline);
                printAddResponse(storedTasks[tasksIndex], tasksIndex+1);
                tasksIndex += 1;
            }
            else{
                storedTasks[tasksIndex] = new Task(input);
                tasksIndex += 1;
                System.out.println("\t" + "added: " + input);
            }
        }

    }
}
