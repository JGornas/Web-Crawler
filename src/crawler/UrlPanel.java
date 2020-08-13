package crawler;

import javax.swing.*;

/**
 * Swing panel (top) containing:
 * Text field for entering URL
 * Button functionality: Downloads page html code. Parses it into tags and urls table panels.
 */
public class UrlPanel extends JPanel {

    JLabel urlLabel = new JLabel("URL:");
    JTextField textField = new JTextField();
    JToggleButton button = new JToggleButton("Parse");
    boolean isPressed = false;

    public UrlPanel(HtmlPanel htmlPanel, TagsPanel tagsPanel, TablePanel tablePanel) {
        add(urlLabel);

        textField.setName("UrlTextField");
        textField.setColumns(40);
        add(textField);

        button.setName("RunButton");
        ActionWorker worker = new ActionWorker(htmlPanel, tagsPanel, tablePanel, textField);
        button.addActionListener(e -> {
            setPressed();
            worker.startThread();
            System.out.println(this.isPressed);
        });
        add(button);
    }
    void setPressed() {
        this.isPressed = !this.isPressed;
    }
}
