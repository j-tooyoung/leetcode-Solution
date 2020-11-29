package Week217;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Classname lc5773
 * @Description
 * @Date 2020/11/22 18:11
 * @Created by j-tooyoung
 */
public class lc5615 {

    public int minMoves(int[] nums, int limit) {
        int len = nums.length;
        int[] sum = new int[len >> 1];
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            sum[i] = nums[i] + nums[len - 1 - i];
            list.add(new int[]{sum[i], Math.min(nums[i], nums[len - 1 - i])});
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[0] - t2[0];
            }
        });
        int ans = 0;
        int mid = list.get(list.size() + 1 >> 1)[0];
        int midpos = list.size() + 1 >> 1;
        System.out.println(mid);
        for (int i = 0; i < list.size(); i++) {
            int diff = mid - list.get(i)[0];
            if (diff == 0) continue;
            int y = mid + list.get(i)[1] - list.get(i)[0] ;
            if (y >= 1 && y <= limit) {
                ans += 1;
            } else {
                ans += 2;
            }
        }

        return ans;
    }
}
