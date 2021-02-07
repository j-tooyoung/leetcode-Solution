import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Classname lc5673
 * @Description
 * @Date 2021/2/7 11:43
 * @Created by j-tooyoung
 */
public class lc5673 {

    public int maximumScore(int a, int b, int c) {
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(a);
        pq.add(b);
        pq.add(c);
        List<Integer> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        Collections.sort(list);
        while (list.size() >= 2) {
            ans += 0;
        }
        return ans;
    }
}
