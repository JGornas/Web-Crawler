package crawler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    public static void log(String message) {
        try (FileWriter writer = new FileWriter(new File("log.txt"), true)) {
            writer.write(message + "\n");
        } catch (IOException e) {
            System.err.print("Something went wrong");
        }
    }
}
