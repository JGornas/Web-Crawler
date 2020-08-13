package crawler;

import javax.swing.*;
import java.awt.*;

public class OptionsPanel extends JPanel {

    JLabel workersLabel = new JLabel("Workers:");
    JTextField workersField = new JTextField();

    JLabel depthLabel = new JLabel("Maximum depth:");
    JTextField depthField = new JTextField();

    JLabel timeLimitLabel = new JLabel("Time limit:");
    JTextField timeLimitField = new JTextField();

    JLabel elapsedTimeLabel = new JLabel("Elapsed pages:");

    JLabel parsedPagesLabel = new JLabel("Parsed pages:");

    public OptionsPanel() {
        super(new GridLayout(4,2));
        add(workersLabel);
        add(workersField);
        workersField.setColumns(40);

        add(depthLabel);
        add(depthField);
        depthField.setName("DepthTextField");
        depthField.setColumns(40);

        add(timeLimitLabel);
        add(timeLimitField);
        timeLimitField.setColumns(40);

        add(elapsedTimeLabel);
        add(parsedPagesLabel);
    }
}
