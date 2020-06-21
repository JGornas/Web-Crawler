package crawler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UrlPanel extends JPanel {

    JTextField textField = new JTextField();
    JButton button = new JButton("Get text!");

    public UrlPanel(HtmlPanel htmlPanel) {
        textField.setName("UrlTextField");
        textField.setColumns(20);
        add(textField);

        button.setName("RunButton");
        button.addActionListener(event -> htmlPanel.setTextArea(textField.getText()));
        add(button);
    }
}
