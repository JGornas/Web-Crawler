package crawler;

import javax.swing.*;
import javax.swing.table.TableColumnModel;

public class TablePanel extends JPanel {
    JTable table;
    String[] columnNames = {"Url", "Title"};
    public TablePanel(DataTable dataTable) {
        String[][] data = dataTable.getTable();
        //JTable table = new JTable(data, columnNames);
        this.table = new JTable(data, columnNames);
        table.setName("TitlesTable");

        table.setSize(500, 200);
        table.setVisible(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        table.setRowHeight(20);
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(250);
        columnModel.getColumn(1).setPreferredWidth(250);
        add(table);
    }
    public void newTable(DataTable dataTable) {
        this.table = new JTable(dataTable.getTable(), columnNames);
        this.table.repaint();
        table.setSize(500, 200);
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setRowHeight(20);
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(250);
        columnModel.getColumn(1).setPreferredWidth(250);

        add(table);
    }
}
