package crawler;

import javax.swing.*;
import java.awt.*;

/**
 * Master window class containing:
 * JFrame init with size, location and layout.
 * HtmlPanel with large text area for html display.
 * UrlPanel with text field and a button for entering URL.
 */
public class WebCrawler extends JFrame {
    public WebCrawler() {
        super("Web Crawler");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 700);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        HtmlPanel htmlPanel = new HtmlPanel();
        TagsPanel tagsPanel = new TagsPanel();
        JPanel urlPanel = new UrlPanel(htmlPanel, tagsPanel);

        add(urlPanel);
        add(tagsPanel);
        add(htmlPanel);
        setVisible(true);
    }
}
