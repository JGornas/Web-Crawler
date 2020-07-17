package crawler;

import javax.swing.*;

/**
 * Swing panel (bottom) containing:
 * Text field for entering file path or name.
 * Button functionality: Saves JTable content into a file.
 */
public class ExportPanel extends JPanel {

    JLabel exportLabel = new JLabel("Export:");
    JTextField textField = new JTextField();
    JButton button = new JButton("Save");

    public ExportPanel(TablePanel tablePanel) {
        super();
        textField.setColumns(35);
        textField.setName("ExportUrlTextField");
        button.setName("ExportButton");

        add(exportLabel);
        add(textField);
        add(button);

        button.addActionListener(e -> FileExporter.export(
                textField.getText(),
                tablePanel.getUrls(),
                tablePanel.getTitles()));
    }

}
