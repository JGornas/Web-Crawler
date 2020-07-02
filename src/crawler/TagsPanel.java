package crawler;

import javax.swing.*;

/**
 * Swing panel (middle) containing:
 * Text label for site title parsed from given html code.
 */
public class TagsPanel extends JPanel {

    JLabel preTitle = new JLabel("Title: ");
    JLabel title = new JLabel();

    public TagsPanel() {
        title.setName("TitleLabel");
        add(preTitle);
        add(title);
    }

    public void setTitle(String parsedTitle) {
        this.title.setText(parsedTitle);
    }
}
