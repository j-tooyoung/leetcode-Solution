package week151;

import java.util.Arrays;

/**
 * @Classname lc1170
 * @Description
 * @Date 2021/1/20 18:41
 * @Created by j-tooyoung
 */
public class lc1170 {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] res = new int[queries.length];

        int[] cnt = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            cnt[i] = calCnt(words[i]);
        }
        Arrays.sort(cnt);
//        Arrays.stream(cnt).forEach(val -> System.out.print(val + " "));
//        System.out.println();

        int len = cnt.length;
        for (int i = 0; i < queries.length; i++) {
            int target = calCnt(queries[i]);
            int idx = search(cnt, target);
            System.out.println(target + " " + idx);
            res[i] = (len - idx);

        }
        return res;
    }

    int search(int[] cnt, int target) {
        int lo = 0, hi = cnt.length;
        while (lo < hi) {
            int mid = lo + hi >> 1;
            if (cnt[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int calCnt(String word) {
        int cnt = 0;
        char minVal = 'z';
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) < minVal) {
                cnt = 1;
                minVal = word.charAt(i);
            } else if(word.charAt(i) == minVal){
                cnt++;
            }
        }
        // System.out.println("word = " + word + " minVal = " + minVal + " cnt = " + cnt);

        return cnt;
    }

}
