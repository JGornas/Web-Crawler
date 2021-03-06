package crawler;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class HtmlDownloader {
    /**
     * Downloads html code from given URL. Returns site's html code tagged at the front in a string.
     *
     * @param url  URL to download.
     */
    public static String download(String url) {
        try (InputStream inputStream = new BufferedInputStream(new URL(url).openStream())) {
            URLConnection connection = new URL(url).openConnection();
            connection.setRequestProperty(
                    "User-Agent", "Mozilla/5.0 (Windows NT 10.0; " +
                    "Win64; x64; rv:63.0) Gecko/20100101 Firefox/63.0");
            int responseCode = ((HttpURLConnection) connection).getResponseCode();
            if (responseCode != 404 || connection.getContentType().contains("text/html")) {
                Logger.log("Downloading url: " + responseCode + " : " + url);
                return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            }
        } catch (IOException | NullPointerException ignore) {}

        return "Invalid URL.";
    }
}
