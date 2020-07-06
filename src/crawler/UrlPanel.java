package crawler;

import javax.swing.*;
import javax.xml.crypto.Data;

/**
 * Swing panel (top) containing:
 * Text field for entering URL
 * Button for running html download and parsing the title. Changes state of html and tags panels.
 */
public class UrlPanel extends JPanel {

    JLabel urlLabel = new JLabel("URL:");
    JTextField textField = new JTextField("https://wykop.pl");
    JButton button = new JButton("Parse");
    DataTable dataTable = new DataTable();

    public UrlPanel(HtmlPanel htmlPanel, TagsPanel tagsPanel, TablePanel tablePanel) {
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

            String[][] data = new String[urls.length][2];
            int index = 0;
            for (String _url : urls) {
                String _html = HtmlDownloader.download(_url);
                if (_html.startsWith("text/html")) {
                    data[index][0] = _url;
                    data[index][1] = HtmlParser.getTitle(_html);
                    System.out.println(_url + " - " + HtmlParser.getTitle(_html));
                }
                index++;
            }
            this.dataTable.setTable(data);
            tablePanel.newTable(this.dataTable);

        });
        add(button);
    }

    public DataTable getDataTable() {
        return this.dataTable;
    }
}
