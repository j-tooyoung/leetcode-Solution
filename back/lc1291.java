import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Classname lc1291
 * @Description
 * @Date 2021/1/24 13:25
 * @Created by j-tooyoung
 */
public class lc1291 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> sequentialDigits(int low, int high) {
        for (int i = 0; i < 10; i++) {
            dfs(low, high, i);
        }
        Collections.sort(list);
        return list;
    }

    private void dfs(int low, int high, int sum) {
        if (sum > high) {
            return;
        }
        if (sum > low) {
            list.add(sum);
        }
        int num = sum % 10;
        if (num < 9) {
            dfs(low, high, sum * 10 + num + 1);
        }
    }

}
