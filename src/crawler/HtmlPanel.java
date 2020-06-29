package crawler;

import javax.swing.*;
import java.awt.*;

/**
 * Swing panel class containing:
 * Text area for browsing html code.
 * Set method to change the text.
 */

public class HtmlPanel extends JPanel {

    JTextArea textArea = new JTextArea();

    public HtmlPanel() {
        textArea.setColumns(45);
        textArea.setRows(35);
        textArea.setName("HtmlTextArea");
        textArea.setEnabled(false);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setDisabledTextColor(Color.black);
        add(textArea);

        JScrollPane scroll = new JScrollPane (textArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scroll);

        setVisible(true);
    }

    public void setTextArea(String text) {
        this.textArea.setText(text);
    }
}
