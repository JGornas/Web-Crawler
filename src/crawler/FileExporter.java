package crawler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileExporter {
    /**
     * Exports JTable content into a file.
     *
     * @param filename Path to the export file.
     * @param urls Urls list from table panel.
     * @param titles Titles list from table panel.
     */
    public static void export(String filename, List<String> urls, List<String> titles) {
        try (FileWriter writer = new FileWriter(new File(filename))) {
            for (int i = 0; i < urls.size(); i++) {
                writer.write(urls.get(i) + "\n");
                writer.write(titles.get(i) + "\n");
            }
            String successMessage = "Exported data to a file: " + filename;
            System.out.println(successMessage);
            Logger.log(successMessage);
        } catch (IOException e) {
            System.err.println("Something went wrong exporting!");
        }
    }
}
