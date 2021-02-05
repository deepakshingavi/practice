import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static void main(String[] args) {


        String text ="{{asasa}}";

        String regex = "\\{[^}]*}*}";

        Pattern placeholderPattern = Pattern.compile(regex);
        Matcher placeholderMatcher = placeholderPattern.matcher(text);
        while (placeholderMatcher.find()) {
            System.out.println("matches = " + placeholderMatcher.group());
        }


    }
}
