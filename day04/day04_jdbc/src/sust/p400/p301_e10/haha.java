package sust.p400.p301_e10;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by SunnyGrocery on 2019/10/19 11:02
 */
public class haha {
    public static void main(String[] args) {
        String s = "Java now has regular expressions";

        List<String> arrayList = new ArrayList<>();
        arrayList.add(".+");
        arrayList.add("^Java");
        arrayList.add("\\Breg.*");
        arrayList.add("n.w\\s+h(a|i)s");
        arrayList.add("s?");
        arrayList.add("s*");
        arrayList.add("s+");
        arrayList.add("s{4}");
        arrayList.add("s{1}");
        arrayList.add("s{0,3}");
//        for (String value : arrayList) {
//            Pattern pattern = Pattern.compile(value);
//            System.out.println(pattern.matcher(s).);
//        }
        for (String value : arrayList) {
            System.out.println(s.matches(value));
        }
    }
}
