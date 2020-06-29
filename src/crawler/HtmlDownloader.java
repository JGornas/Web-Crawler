package crawler;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HtmlDownloader {
    /**
     * Downloads html code from given URL. Changes state of htmlPanel instance text area.
     *
     * @param url  URL to download.
     * @param htmlPanel  HtmlPanel object instance.
     */
    public static void download(String url, HtmlPanel htmlPanel) {
        try (InputStream inputStream = new BufferedInputStream(new URL(url).openStream())) {
            String siteText = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            htmlPanel.setTextArea(siteText);
        } catch (IOException e) {
            htmlPanel.setTextArea("Invalid URL.");
        }
    }
}
