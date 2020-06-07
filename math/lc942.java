import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class lc942 {
    //我们维护当前未使用的最小和最大的数，它们对应的区间为当前未使用的数的集合。从左向右扫描字符串，如果碰到 'I'，就取出当前最小的数，否则取出当前最大的数。
    public static int[] diStringMatch(String S) {

        int len = S.length();
        int[] res = new int[len + 1];
        int lo = 0, hi = len;
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == 'I') {
                res[i] = lo++;
            } else {
                res[i] = hi--;
            }
        }
        res[len] = lo;
        return res;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(){{
            add("IDID");
            add("III");
            add("DDI");
        }};
        for (String s : list) {
            System.out.println(Arrays.toString(diStringMatch(s)));
//            System.out.println();
        }
    }
}
