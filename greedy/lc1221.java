import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class lc1221 {
    //Loop from left to right maintaining a balance variable when it gets an L increase it by one otherwise decrease it by one.
    // Whenever the balance variable reaches zero then we increase the answer by one.
    public static int balancedStringSplit(String s) {
        int res = 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') cnt++;
            else cnt--;
            if (cnt == 0) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(){{
            add("RLRRLLRLRL");
            add("RLLLLRRRLR");
            add("LLLLRRRR");
            add(" ");
        }};
        for (String s : list) {
            System.out.println(balancedStringSplit(s));
        }
    }
}
