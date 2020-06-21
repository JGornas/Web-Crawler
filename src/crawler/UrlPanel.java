package crawler;

import javax.swing.*;

public class UrlPanel extends JPanel {

    JTextField textField = new JTextField();
    JButton button = new JButton("Get text!");

    public UrlPanel(HtmlPanel htmlPanel) {
        textField.setName("UrlTextField");
        textField.setColumns(35);
        add(textField);

        button.setName("RunButton");
        button.addActionListener(event -> HtmlDownloader.download(textField.getText(), htmlPanel));
        add(button);
    }
}
