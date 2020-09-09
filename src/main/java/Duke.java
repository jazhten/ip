import java.util.Scanner;

public class Duke {

    public static void main(String[] args) throws DukeException {
        StringOperations.printIntroduction();
        Scanner inputScanner = new Scanner(System.in);
        final int MAX_TASK_NUM = 100;
        InputManager manager = new InputManager(MAX_TASK_NUM);
        while (!manager.getTerminationStatus()) {
            System.out.print("\u2658 : ");
            manager.handleInput(inputScanner.nextLine());
        }
    }

}


