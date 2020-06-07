import java.util.Stack;

/**
 * 739. 每日温度
 * https://leetcode-cn.com/problems/daily-temperatures/
 */
public class lc739 {

    // 单调栈
    public static int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] res = new int[T.length];
        Stack<Integer> st = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!st.isEmpty() && T[st.peek()] <= T[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? 0 : st.peek() - i;
            st.push(i);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
