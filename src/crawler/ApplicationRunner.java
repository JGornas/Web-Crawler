package crawler;

import javax.swing.*;

/**
 * @author JGornas
 * @version 0.4
 *
 * Main method of Web Crawler app.
 */
public class ApplicationRunner {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new WebCrawler();
            }
        });
        System.out.println("Initial Thread is dispatch: " + SwingUtilities.isEventDispatchThread());


        // OR
        // SwingUtilities.invokeLater(() -> new WebCrawler());
        // OR (best one)
        // SwingUtilities.invokeLater(WebCrawler::new);


    }
}
