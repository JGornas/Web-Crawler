package crawler;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HtmlDownloader {
    public static void download(String url, HtmlPanel htmlPanel) {
        try (InputStream inputStream = new BufferedInputStream(new URL(url).openStream())) {
            String siteText = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            htmlPanel.setTextArea(siteText);
        } catch (IOException ignore) {}
    }
}
