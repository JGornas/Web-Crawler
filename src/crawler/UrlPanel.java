package crawler;

import javax.swing.*;

/**
 * Swing panel (top) containing:
 * Text field for entering URL
 * Button functionality: Downloads page html code. Parses it into tags and urls table panels.
 */
public class UrlPanel extends JPanel {

    JLabel urlLabel = new JLabel("URL:");
    JTextField textField = new JTextField();
    JButton button = new JButton("Parse");

    public UrlPanel(HtmlPanel htmlPanel, TagsPanel tagsPanel, TablePanel tablePanel) {
        add(urlLabel);

        textField.setName("UrlTextField");
        textField.setColumns(40);
        add(textField);

        button.setName("RunButton");
        button.addActionListener(e -> {
            Logger.log("Next url... ");
            String url = textField.getText();
            String html = HtmlDownloader.download(url);
            String title = HtmlParser.getTitle(html);
            htmlPanel.setTextArea(html);
            tagsPanel.setTitle(title);
            Logger.log("Parsing urls... ");
            tablePanel.updateTable(url, title, HtmlParser.getUrls(html, url));
        });
        add(button);
    }
}
