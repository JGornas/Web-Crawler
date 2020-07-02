package crawler;

import javax.swing.*;

/**
 * Swing panel (top) containing:
 * Text field for entering URL
 * Button for running html download and parsing the title. Changes state of html and tags panels.
 */
public class UrlPanel extends JPanel {

    JLabel urlLabel = new JLabel("URL:");
    JTextField textField = new JTextField();
    JButton button = new JButton("Get text!");

    public UrlPanel(HtmlPanel htmlPanel, TagsPanel tagsPanel) {
        add(urlLabel);

        textField.setName("UrlTextField");
        textField.setColumns(35);
        add(textField);

        button.setName("RunButton");
        button.addActionListener(e -> {
            String html = HtmlDownloader.download(textField.getText());
            htmlPanel.setTextArea(html);
            tagsPanel.setTitle(HtmlParser.getTitle(html));
        });
        add(button);
    }
}
