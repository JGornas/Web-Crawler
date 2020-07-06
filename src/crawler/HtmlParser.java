package crawler;

import java.util.ArrayList;
import java.util.List;
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

    public static List<String> getLinks(String html, String url) {
        List<String> linksList = new ArrayList<>();

        Pattern pattern = Pattern.compile(
              //  "(//)(([\\w_-]+(?:(?:\\.[\\w_-]+)+))([\\w.,@?^=%&:/~+#-]*[\\w@?^=%&/~+#-])?)",
                "(<a href=\"(https:|http:)?)(//?[-a-zA-Z!@#$%^&*.,_;/0-9:]+)",
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(html);
        while(matcher.find()) {
            linksList.add(matcher.group(3));
        }

        for (String s : linksList) {
            if (s.startsWith("//")) {
                System.out.println("https:" + s);
            } else if (s.startsWith("/")) {
                System.out.println("https://elo" + s);
            }
        }
        System.out.println(linksList.size());

        return linksList;
    }
}
