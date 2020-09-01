import java.util.Scanner;

public class Duke {
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
                StringOperations.printList(storedTasks,tasksIndex);
            }
            else if (input.equals("bye")) {
                System.out.println("Bye. May the Force be with you.");
                break;
            }
            else if (splitInput[0].equals("done")){
                int taskNum = Integer.parseInt(splitInput[1])-1;
                storedTasks[taskNum].completeTask();
                StringOperations.completeTask(storedTasks,taskNum);
            }
            else if (splitInput[0].equals("todo")){
                String description = input.substring(StringOperations.getFirstSpace(input));
                storedTasks[tasksIndex] = new Todo(description);
                StringOperations.printAddResponse(storedTasks[tasksIndex], tasksIndex+1);
                tasksIndex += 1;
            }
            else if (splitInput[0].equals("deadline")){
                storedTasks[tasksIndex] = new Deadline(StringOperations.getDescription(input),
                        StringOperations.getDeadline(input));
                StringOperations.printAddResponse(storedTasks[tasksIndex], tasksIndex+1);
                tasksIndex += 1;
            }
            else if (splitInput[0].equals("event")){
                storedTasks[tasksIndex] = new Event(StringOperations.getDescription(input),
                        StringOperations.getDeadline(input));
                StringOperations.printAddResponse(storedTasks[tasksIndex], tasksIndex+1);
                tasksIndex += 1;
            }
            else{
                storedTasks[tasksIndex] = new Task(input);
                System.out.println("\t" + "added: " + input);
                tasksIndex += 1;
            }
        }

    }
}
