package crawler;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TablePanel extends JPanel {

    final private JTable table;

    private final List<String> urls = new ArrayList<>();
    private final List<String> titles = new ArrayList<>();
    private final TablePanelTableModel newTableModel = new TablePanelTableModel(urls, titles);

    public TablePanel() {
        super(new BorderLayout());
        this.table = new JTable(newTableModel);

        table.setName("TitlesTable");
        table.setSize(500, 500);
        table.setVisible(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        table.setRowHeight(20);
        table.setEnabled(false);

        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void updateTable(String url, String title, String[] parsedUrls) {
        this.urls.clear();
        this.titles.clear();
        urls.add(url);
        titles.add(title);
        for (String parsedUrl : parsedUrls) {
            String html = HtmlDownloader.download(parsedUrl);
            if (html.toLowerCase().startsWith("<!doctype html>")) {
                this.urls.add(parsedUrl);
                this.titles.add(HtmlParser.getTitle(html));
            }
        }
        newTableModel.fireTableDataChanged();
    }
}
