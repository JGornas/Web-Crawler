package crawler;

import javax.swing.*;

/**
 * Swing panel (top) containing:
 * Text field for entering URL
 * Button for running html download and parsing the title. Changes state of html and tags panels.
 */
public class UrlPanel extends JPanel {

    JLabel urlLabel = new JLabel("URL:");
    JTextField textField = new JTextField("https://en.wikipedia.org/wiki/Hyperlink");
    JButton button = new JButton("Parse");

    public UrlPanel(HtmlPanel htmlPanel, TagsPanel tagsPanel) {
        add(urlLabel);

        textField.setName("UrlTextField");
        textField.setColumns(35);
        add(textField);

        button.setName("RunButton");
        button.addActionListener(e -> {
            String url = textField.getText();
            String html = HtmlDownloader.download(url);
            htmlPanel.setTextArea(html);
            tagsPanel.setTitle(HtmlParser.getTitle(html));

            String[] urls = HtmlParser.getUrls(html, url);
            for (String _url : urls) {
                String _html = HtmlDownloader.download(_url);
                if (_html.startsWith("text/html")) {
                    System.out.println(_url + " - " + HtmlParser.getTitle(_html));
                }
            }
        });
        add(button);
    }
}
