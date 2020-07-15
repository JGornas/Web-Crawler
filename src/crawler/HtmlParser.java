package crawler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlParser {
    /**
     * Parses the title tag from html code.
     *
     * @param html  Html code string.
     * @return Match result.
     */
    public static String getTitle(String html) {
        Pattern pattern = Pattern.compile("(<title>)(.*)(</title>)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(html);
        if (matcher.find()) {
            return matcher.group(2);
        } else {
            return "No match found.";
        }
    }

    /**
     * Parses all urls from a website.
     *
     * @param html Html code string.
     * @param url Url from UrlPanel.
     * @return String array of parsed urls.
     */
    public static String[] getUrls(String html, String url) {
        Logger.log("Website: " + url);
        Set<String> urlSet = new HashSet<>();
        Pattern pattern = Pattern.compile(
                "(<a href=\"(https:|http:)?)(/?/?[-a-zA-Z!@#$%^&*.,_;/0-9:]+)",
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()) {
            urlSet.add(matcher.group(3));
        }

        Pattern urlRegex = Pattern.compile("(https:|http:)(//[a-zA-Z0-9./_-]+)");
        Matcher urlMatcher = urlRegex.matcher(url);
        urlMatcher.find();

        String[] parsedUrls = new String[urlSet.size()];
        int index = 0;
        int newArrayLength = 0;

        for (String s : urlSet) {
            //System.out.println(s);



            if (s.equals("unavailablePage")) {
                System.out.println("UNAVAILABLE");

            }

            if (s.startsWith("//")) {
                parsedUrls[index] = "https:" + s;
                System.out.println(parsedUrls[index]);
            } else if (s.startsWith("/")) {
                parsedUrls[index] = "https:" + urlMatcher.group(2) + s;
                System.out.println(parsedUrls[index]);
            } else {
                System.out.println(s);
                if (!s.equals("unavailablePage")) {
                    parsedUrls[index] = "http://localhost:25555/" + s;
                    System.out.println(parsedUrls[index]);
                }
            }


            if (parsedUrls[index] == null) {
                System.out.println("NULL FOUND");
            } else {
                newArrayLength++;
            }
            index++;
        }

        String[] newParsedUrls = new String[newArrayLength];
        for (int i = 0; i < newArrayLength; i++) {
            if (parsedUrls[i] != null) {
                newParsedUrls[i] = parsedUrls[i];
            }
        }
        for (String element : newParsedUrls) {
            Logger.log("Parsed url: " + element);
        }
        if (newParsedUrls.length == 0) {
            Logger.log("No parsed links");
        }
        return newParsedUrls;
    }
}
