package crawler;

import javax.swing.*;

public class HtmlPanel extends JPanel {
    JTextArea textArea = new JTextArea();

    public HtmlPanel() {
        textArea.setText("HTML code?");
        textArea.setColumns(27);
        textArea.setRows(27);
        textArea.setName("TextArea");
        // textArea.setEnabled(false);
        textArea.setEditable(false);
        add(textArea);
        setVisible(true);
    }

    public void setTextArea(String text) {
        this.textArea.setText(text);
    }
}
