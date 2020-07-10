package crawler;

import javax.swing.*;
import java.awt.*;

/**
 * Main Frame,  contains:
 * JFrame init with size, location and layout.
 * Tabbed pane with html and table panels.
 * HtmlPanel with large text area for html display.
 * UrlPanel with text field and a button for entering URL.
 * TablePanel for displaying parsed urls.
 */
public class WebCrawler extends JFrame {
    public WebCrawler() {
        super("Web Crawler");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 750);
        setLocationRelativeTo(null);
        //setLayout(new FlowLayout());

        HtmlPanel htmlPanel = new HtmlPanel();
        TagsPanel tagsPanel = new TagsPanel();
        TablePanel tablePanel = new TablePanel();

        UrlPanel urlPanel = new UrlPanel(htmlPanel, tagsPanel, tablePanel);
        JTabbedPane tabbedPane = new JTabbedPane();

        add(urlPanel, BorderLayout.NORTH);
        add(tagsPanel, BorderLayout.CENTER);

        tabbedPane.addTab("URLS", new JScrollPane(tablePanel));
        tabbedPane.addTab("HTML", htmlPanel);
        add(tabbedPane, BorderLayout.SOUTH);

        setVisible(true);
    }
}
