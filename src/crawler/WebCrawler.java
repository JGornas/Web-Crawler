package crawler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Main Frame,  contains:
 * JFrame init with size, location and layout.
 * UrlPanel with text field and a button for entering URL.
 * Tabbed pane with urls table, html viewer and options panel.
 * HtmlPanel consists of large text area for html display.
 * TablePanel consists of a table of parsed urls.
 * Options panel contains: TODO : options panel, multithreading
 */
public class WebCrawler extends JFrame {
    public WebCrawler() {
        super("Web Crawler");
        Logger.log("\nNew log:");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(575, 730);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        System.out.println("Main frame Thread is dispatch: " + SwingUtilities.isEventDispatchThread());

        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });

        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        JPanel bottom = new JPanel();
        bottom.setLayout(new BorderLayout());

        HtmlPanel htmlPanel = new HtmlPanel();
        TagsPanel tagsPanel = new TagsPanel();
        TablePanel tablePanel = new TablePanel();

        OptionsPanel optionsPanel = new OptionsPanel();

        ExportPanel exportPanel = new ExportPanel(tablePanel);
        UrlPanel urlPanel = new UrlPanel(htmlPanel, tagsPanel, tablePanel);
        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Options", optionsPanel);
        tabbedPane.addTab("Urls", new JScrollPane(tablePanel));
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
