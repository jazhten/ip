import java.util.Scanner;

public class Duke {

    public static void main(String[] args) throws DukeException {
        StringOperations.printIntroduction();
        Scanner inputScanner = new Scanner(System.in);
        InputManager manager = new InputManager();
        while (!manager.getTerminationStatus()) {
            System.out.print("\u2658 : ");
            manager.handleInput(inputScanner.nextLine());
        }
    }

}


