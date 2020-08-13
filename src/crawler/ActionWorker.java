package crawler;

import javax.swing.*;

public class ActionWorker {

    HtmlPanel htmlPanel;
    TagsPanel tagsPanel;
    TablePanel tablePanel;
    JTextField textField;

    public ActionWorker(HtmlPanel htmlPanel, TagsPanel tagsPanel,
                        TablePanel tablePanel, JTextField textField) {
        this.htmlPanel = htmlPanel;
        this.tagsPanel = tagsPanel;
        this.tablePanel = tablePanel;
        this.textField = textField;
    }

    protected void startThread() {

        SwingWorker worker = new SwingWorker() {

            // według dokumentacji : TO NIE POWINNO BYć tutaj: to jest even dispatch,
            // on zarządza innymi workerami

            @Override
            public Object doInBackground() {
                Logger.log("Next url... ");
                String url = textField.getText();
                String html = HtmlDownloader.download(url);
                String title = HtmlParser.getTitle(html);
                htmlPanel.setTextArea(html);
                tagsPanel.setTitle(title);
                Logger.log("Parsing urls... ");
                tablePanel.updateTable(url, title, HtmlParser.getUrls(html, url));
                return null;
            }
            @Override
            public void done() {
                System.out.println("Action Thread is dispatch: " + SwingUtilities.isEventDispatchThread());
                System.out.println("Action task done!");
            }

        };
        worker.execute();
    }
}
