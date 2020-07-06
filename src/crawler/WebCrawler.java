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
        setSize(550, 700);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        HtmlPanel htmlPanel = new HtmlPanel();
        TagsPanel tagsPanel = new TagsPanel();

        DataTable dataTable = new DataTable();
        TablePanel tablePanel = new TablePanel(dataTable);
        UrlPanel urlPanel = new UrlPanel(htmlPanel, tagsPanel, tablePanel);



        JTabbedPane tabbedPane = new JTabbedPane();
        add(urlPanel);
        add(tagsPanel);

        tabbedPane.addTab("HTML", null, htmlPanel, "Does nothing");
        tabbedPane.addTab("URLS", null, new JScrollPane(tablePanel), "Does nothing");
        add(tabbedPane);


        setVisible(true);
    }
}
