package crawler;

import javax.swing.*;

/**
 * Swing panel (top) containing:
 * Text field for entering URL
 * Button functionality: Downloads page html code. Parses it into tags and urls table panels.
 */
public class UrlPanel extends JPanel {

    JLabel urlLabel = new JLabel("URL:");
    JTextField textField = new JTextField("https://wykop.pl");
    JButton button = new JButton("Parse");

    public UrlPanel(HtmlPanel htmlPanel, TagsPanel tagsPanel, TablePanel tablePanel) {
        add(urlLabel);

        textField.setName("UrlTextField");
        textField.setColumns(40);
        add(textField);

        button.setName("RunButton");
        button.addActionListener(e -> {
            String url = textField.getText();
            String html = HtmlDownloader.download(url);
            htmlPanel.setTextArea(html);
            tagsPanel.setTitle(HtmlParser.getTitle(html));
            tablePanel.updateTable(HtmlParser.getUrls(html, url));
        });
        add(button);
    }
}
