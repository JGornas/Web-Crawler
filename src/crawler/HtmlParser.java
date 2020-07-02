package crawler;

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
}
