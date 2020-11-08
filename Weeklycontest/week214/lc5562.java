package week214;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Classname lc5562
 * @Description
 * 5562. 字符频次唯一的最小删除次数
 * https://leetcode-cn.com/contest/weekly-contest-214/problems/minimum-deletions-to-make-character-frequencies-unique/
 * @Date 2020/11/8 10:39
 * @Created by j-tooyoung
 */
public class lc5562 {

    public int minDeletions(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        Arrays.sort(cnt);
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int i = cnt.length - 1; i >= 0; i--) {
            System.out.println(cnt[i]);
            if (cnt[i] ==0) continue;

            while (set.contains(cnt[i]) && cnt[i] !=0) {
                cnt[i]--;
                res++;
            }
            set.add(cnt[i]);
        }
        return res;
    }

}
// b2 a3 e1 c2
// 2a 2b 2c
// 4b 1c 1e 1a
