package crawler;

public class DataTable {

    private String[][] data;
    public DataTable() {
        this.data = new String[1][2];
    }
    public void setTable(String[][] data) {
        this.data = data;
    }
    public String[][] getTable() {
        return data;
    }
}
