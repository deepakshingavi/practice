import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecurseStrDuplicate {

    public static void main(String[] args) {
//        System.out.println(removeCons("aabccba"));
//        System.out.println(removeCons("aaaaaa"));
//        System.out.println(removeCons(""));

        List<String> forbidden_words = Arrays.asList("test","one","two");


        List<String> list1 = Arrays.asList("eiofjfrgj_test","oiione","rrrtwo", "normal", "word");

        list1.removeAll(forbidden_words);

        List<String> forbidden_word_list = new ArrayList(Arrays.asList(forbidden_words));
        List<String> list2 = new ArrayList(Arrays.asList(list1));
        list2.removeAll(list2);
        System.out.println(Arrays.asList(forbidden_words).remove("one"));
    }

    public static String removeCons(String s) {
        if(s.isEmpty()) return s;

        String ans = "";

        String rest = "";

        if(s.charAt(0) == s.charAt(1)) {
            ans += s.charAt(0);
            rest = removeCons(s.substring(2));
        }
        else {
            ans += s.charAt(0);
            rest = removeCons(s.substring(1));
        }

        return ans+rest;
    }


}
