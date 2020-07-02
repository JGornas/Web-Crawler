package crawler;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HtmlDownloader {
    /**
     * Downloads html code from given URL. Returns site's html code in a string.
     *
     * @param url  URL to download.
     */
    public static String download(String url) {
        try (InputStream inputStream = new BufferedInputStream(new URL(url).openStream())) {
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            return "Invalid URL.";
        }
    }
}
