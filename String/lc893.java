import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 893. 特殊等价字符串组
 * https://leetcode-cn.com/problems/groups-of-special-equivalent-strings/
 *
 */
public class lc893 {

    // 因为可以任意次调换，所以求出偶位数的字符even，奇位数的字符odd，再sort后相加，用set去重
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (String s : A) {
            StringBuilder sb = new StringBuilder();
            int len = s.length();
            int[] arr1 = new int[len / 2 + (len % 2)];
            int[] arr2 = new int[len / 2];
            int idx1 = 0;
            int idx2 = 0;
            for (int i = 0; i < len; i ++) {
                if (i % 2 == 0) {
                    arr1[idx1++] = s.charAt(i);
                } else {
                    arr2[idx2++] = s.charAt(i);
                }
            }
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            sb.append(Arrays.toString(arr1)).append(Arrays.toString(arr2));
            set.add(sb.toString());
        }
        return set.size();
    }


}
