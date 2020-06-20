package crawler;

import javax.swing.*;

public class WebCrawler extends JFrame {
    public WebCrawler() {
        super("Simple Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);

        JPanel textPanel = new TextPanel();
        add(textPanel);

        setVisible(true);
    }
}
