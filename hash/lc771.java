import java.util.HashSet;
import java.util.Set;

/**
 * @Classname lc771
 * @Date 2020/10/2 7:36
 * @Created by xp123
 * 771. 宝石与石头
 */
public class lc771 {

    public int numJewelsInStones(String J, String S) {
        int res = 0;
//        Map<Character, I>
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                res++;
            }
        }
        return res;
    }

}
