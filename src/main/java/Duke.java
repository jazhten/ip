import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello there General Kenobi! I'm\n" + logo);
        System.out.println("How may I be at your pleasure today?");
        Scanner sc = new Scanner(System.in);
        Task[] storedTasks = new Task[100];
        int index = 0;
        while (true) {
            String input = sc.nextLine();
            String[] splitInput = input.split(" ");
            if(input.equals("list")){
                System.out.println("\tHere are the tasks in your list:");
                for(int i=0;i<index;i++){
                    System.out.println("\t"+(i+1) +". "+ storedTasks[i].getTaskInfo());
                }
            }
            else if (input.equals("bye")) {
                System.out.println("Bye. May the Force be with you.");
                break;
            }
            else if (splitInput[0].equals("done")){
                int taskNum = Integer.parseInt(splitInput[1])-1;
                storedTasks[taskNum].completeTask();
                String task = storedTasks[taskNum].getTaskName();
                System.out.println("\tNice! I've marked this task as done: ");
                System.out.println("\t  " + storedTasks[taskNum].getTaskInfo());
            }
            else{
                storedTasks[index] = new Task(input);
                index += 1;
                System.out.println("\t" + "added: " + input);
            }
        }

    }
}
