import java.util.LinkedList;
import java.util.Queue;

/**
 * 933. 最近的请求次数
 * https://leetcode-cn.com/problems/number-of-recent-calls/
 *
 */
public class RecentCounter {

    Queue<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }


    public static void main(String[] args) {

    }

}
