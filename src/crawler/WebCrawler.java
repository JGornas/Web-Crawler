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
        Logger.log("\nNew log:");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(575, 730);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        JPanel bottom = new JPanel();
        bottom.setLayout(new BorderLayout());

        HtmlPanel htmlPanel = new HtmlPanel();
        TagsPanel tagsPanel = new TagsPanel();
        TablePanel tablePanel = new TablePanel();

        ExportPanel exportPanel = new ExportPanel(tablePanel);
        UrlPanel urlPanel = new UrlPanel(htmlPanel, tagsPanel, tablePanel);
        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("URLS", new JScrollPane(tablePanel));
        tabbedPane.addTab("HTML", htmlPanel);

        top.add(urlPanel, BorderLayout.NORTH);
        top.add(tagsPanel, BorderLayout.CENTER);
        top.add(tabbedPane, BorderLayout.SOUTH);

        bottom.add(exportPanel, BorderLayout.NORTH);

        add(top, BorderLayout.NORTH);
        add(bottom, BorderLayout.CENTER);
        setVisible(true);
    }
}
