import java.util.Arrays;

public class CheckAnagrams {

    public static void main(String[] args) {
        String firstString = "triangle";
        String secondString = "integral";

        if (checkForAnaGrams(firstString, secondString)) {
            System.out.println(firstString + " and " + secondString + " are a Anagram");
        } else {
            System.out.println(firstString + " and " + secondString + " are not a Anagram");
        }
        firstString = "ABC";
        secondString = "DEF";
        if (checkForAnaGrams(firstString, secondString)) {
            System.out.println(firstString + " and " + secondString + " are a Anagram");
        } else {
            System.out.println(firstString + " and " + secondString + " are not a Anagram");
        }
    }

    private static boolean checkForAnaGrams(String string1, String string2) {
        if (string1 == null || string2 == null || (string1.length() != string2.length())) {
            return false;
        }
        final char[] chars = string1.toCharArray();
        Arrays.sort(chars); // nlogn
        final char[] chars1 = string2.toCharArray();
        Arrays.sort(chars1); // nlogn
        for (int i = 0; i < chars.length; i++) { // n
            if (chars[i] != chars1[i]) {
                return false;
            }
        }
        return true;
    }
}
