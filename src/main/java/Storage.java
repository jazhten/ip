import EntryItems.Event;
import EntryItems.Task;
import EntryItems.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {

    protected static String filePath;

    Storage(String filePath) {
        this.filePath = filePath;
    }
    public static ArrayList<Task> loadSaveFile() throws FileNotFoundException {
        File directory = new File("data");
        if (!directory.exists()) {
            directory.mkdir();
        }
        ArrayList<Task> loadedTasks = new ArrayList<>();
        File f = new File(filePath); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        int index = 0;
        while (s.hasNext()) {
            String[] entry = s.nextLine().split("\\|");
            switch (entry[0]) {
            case "T":
                loadedTasks.add(new Todo(entry[2]));
                if (entry[1].equals("1")) {
                    loadedTasks.get(index).MarkDone();
                }
                break;
            case "E":
                loadedTasks.add(new Event(entry[2], entry[3]));
                if (entry[1].equals("1")) {
                    loadedTasks.get(index).MarkDone();
                }
                break;
            case "D":
                loadedTasks.add(new Deadline(entry[2], entry[3]));
                if (entry[1].equals("1")) {
                    loadedTasks.get(index).MarkDone();
                }
                break;
            }
            index += 1;
        }
        return loadedTasks;
    }


    public static void saveData(ArrayList<Task> taskList) {
        try {
            FileWriter fw = new FileWriter("data/Duke.txt");
            for (Task taskItem : taskList) {
                fw.write(taskItem.saveValue() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            Ui.printIOException();
        }
    }
}
