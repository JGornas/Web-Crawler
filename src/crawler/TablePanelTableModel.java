package crawler;

import javax.swing.table.AbstractTableModel;
import java.util.*;

public class TablePanelTableModel extends AbstractTableModel {

    private final List<String> urls;
    private final List<String> titles;
    private final String[] headers = {"URL", "Title"};

    public TablePanelTableModel(List<String> urls, List<String> titles) {
        super();
        this.urls = urls;
        this.titles = titles;
    }

    @Override
    public int getRowCount() {
        return urls.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public String getValueAt(int row, int column) {
        return column == 0 ? urls.get(row) : titles.get(row);
    }

    @Override
    public String getColumnName(int columnIndex) {
        return headers[columnIndex];
    }
}