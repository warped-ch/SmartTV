package org.dev.warped.smarttv;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegExParser {

    private RegExParser() {
    }

    static String getIMDbRating(String string, String prefix) {
        if (null != string) {
            Pattern pattern = Pattern.compile("(?i)imdb[: rating]+([0-9]*\\.[0-9]+|[0-9]+)");
            Matcher matcher = pattern.matcher(string);
            return matcher.find() ? prefix + ": " + matcher.group(1) : prefix;
        }
        return prefix;
    }
}
