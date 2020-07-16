package crawler;

import javax.swing.*;
import java.awt.*;

/**
 * Swing panel (bottom) containing:
 * Large text area for browsing html code.
 * Set method to change the text inside it.
 */
public class HtmlPanel extends JPanel {

    JTextArea textArea = new JTextArea();

    public HtmlPanel() {
        super(new BorderLayout());
        textArea.setColumns(45);
        textArea.setRows(35);
        textArea.setName("HtmlTextArea");
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
