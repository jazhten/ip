public class StringOperations {
    public static int getFirstSpace(String input){
        return input.indexOf(" ");
    }

    public static void printAddResponse(Task task, int index){
        System.out.println("\tGot it. I've added this task:");
        System.out.println("\t" + task.toString());
        System.out.println("\tNow you have " + index + " tasks in the list");
    }

    public static void printList(Task[] tasks,int taskIndex){
        System.out.println("\tHere are the tasks in your list:");
        for(int i=0;i<taskIndex;i++){
            System.out.println("\t"+(i+1) +". "+ tasks[i].toString());
        }
    }

    public static void completeTask(Task[] tasks,int taskIndex){
        System.out.println("\tNice! I've marked this task as done: ");
        System.out.println("\t  " + tasks[taskIndex].toString());
    }

    public static String getDescription(String input){
        int startPoint = input.indexOf("/");
        return input.substring(getFirstSpace(input),startPoint);
    }

    public static String getDeadline(String input){
        int startPoint = input.indexOf("/");
        String fullDeadline =  input.substring(startPoint);
        fullDeadline =  fullDeadline.replace("/at ","");
        fullDeadline = fullDeadline.replace("/by ","");
        return fullDeadline;
    }
}
