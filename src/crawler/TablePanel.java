package crawler;

import javax.swing.*;
import javax.swing.table.TableColumnModel;

public class TablePanel extends JPanel {
    JTable table;
    String[] columnNames = {"Url", "Title"};
    public TablePanel(DataTable dataTable) {
        String[][] data = dataTable.getTable();
        this.table = new JTable(data, columnNames);
        table.setName("TitlesTable");
        table.setSize(500, 200);
        table.setVisible(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        table.setRowHeight(20);
        table.setEnabled(false);
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(250);
        columnModel.getColumn(1).setPreferredWidth(250);
        add(new JScrollPane(table));
    }

    public void updateTable(String[] urls) {
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
    }
}
