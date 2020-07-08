package crawler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.util.ArrayList;
import java.util.List;

public class TablePanel extends JPanel {

    JTable table;
    DefaultTableModel tableModel = new DefaultTableModel();

    public TablePanel() {
        this.table = new JTable(tableModel);
        table.setName("TitlesTable");
        table.setSize(500, 500);
        table.setVisible(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        table.setRowHeight(20);
        table.setEnabled(false);

        tableModel.addColumn("Url");
        tableModel.addColumn("Title");
        tableModel.addRow(new String[] {"", ""});
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(250);
        columnModel.getColumn(1).setPreferredWidth(250);

        add(new JScrollPane(table));
    }

    public void updateTable(String[] urls) {
        tableModel.setRowCount(0);
        List<String[]> parsedUrlsList = new ArrayList<>();
        for (String _url : urls) {
            String _html = HtmlDownloader.download(_url);
            if (_html.startsWith("text/html")) {
                parsedUrlsList.add(new String[] {_url, HtmlParser.getTitle(_html)});
            }
        }
        for (String[] pair : parsedUrlsList) {
            for (String element : pair) {
                System.out.println(element);
            }
        }
        for (String[] strings : parsedUrlsList) {
            tableModel.addRow(new String[] {strings[0], strings[1]});
        }
        table.repaint();
    }
}
