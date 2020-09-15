import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SaveFile {

    //open

    public static Task[] loadSaveFile(int size) throws FileNotFoundException {
        File directory = new File("data");
        if (! directory.exists()){
            directory.mkdir();
        }
        Task[] loadedTasks = new Task[size];
        File f = new File("data/Duke.txt"); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        int index = 0;
        while (s.hasNext()) {
            String[] entry = s.nextLine().split("\\|");
            switch (entry[0]) {
            case "T":
                loadedTasks[index] = new Todo(entry[2]);
                if (entry[1].equals("1")) {
                    loadedTasks[index].MarkDone();
                }
                break;
            case "E":
                loadedTasks[index] = new Event(entry[2], entry[3]);
                if (entry[1].equals("1")) {
                    loadedTasks[index].MarkDone();
                }
                break;
            case "D":
                loadedTasks[index] = new Deadline(entry[2], entry[3]);
                if (entry[1].equals("1")) {
                    loadedTasks[index].MarkDone();
                }
                break;
            }
            index += 1;
        }
        return loadedTasks;
    }


    public static void saveData(Task[] taskList, int index) {
        try {
            FileWriter fw = new FileWriter("data/Duke.txt");
            for (int i = 0; i < index; i++) {
                fw.write(taskList[i].saveValue() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            System.out.println(DukeException.ExceptionResponse.EXCEPTION_IO_EXCEPTION);
        }
    }
}
