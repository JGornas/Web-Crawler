package crawler;

import javax.swing.*;

public class TextPanel extends JPanel {
    public TextPanel() {
        JTextArea textArea = new JTextArea();
        textArea.setText("HTML code?");
        textArea.setBounds(100, 100, 100, 100);
        textArea.setName("TextArea");
        textArea.setEnabled(false);
        add(textArea);
        setVisible(true);
    }
}
