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
        String[] storedTexts = new String[100];
        int index = 0;
        while (true) {
            String input = sc.nextLine();
            if(input.equals("list")){
                for(int i=0;i<index;i++){
                    System.out.println("\t"+(i+1) +". "+ storedTexts[i]);
                }
            }
            else if (input.equals("bye")) {
                System.out.println("Bye. May the Force be with you.");
                break;
            }
            else{
                storedTexts[index] = input;
                index += 1;
                System.out.println("\t" + "added: " + input);
            }
        }

    }
}
