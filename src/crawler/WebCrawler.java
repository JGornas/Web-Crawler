package crawler;

import javax.swing.*;
import java.awt.*;

public class WebCrawler extends JFrame {
    public WebCrawler() {
        super("Web Crawler");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 660);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        HtmlPanel htmlPanel = new HtmlPanel();
        JPanel urlPanel = new UrlPanel(htmlPanel);

        add(urlPanel);
        add(htmlPanel);
        setVisible(true);
    }
}
