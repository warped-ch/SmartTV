package org.dev.warped.smarttv;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Andreas Wiedmer on 29.07.2016.
 */
class RegExParser {

    static String getIMDbRating(String string, String prefix) {
        if (null != string) {
            Pattern pattern = Pattern.compile("(?i)imdb[: rating]+([0-9]*\\.[0-9]+|[0-9]+)");
            Matcher matcher = pattern.matcher(string);
            return matcher.find() ? prefix + ": " + matcher.group(1) : prefix;
        }
        return prefix;
    }

    private RegExParser() {
    }
}
