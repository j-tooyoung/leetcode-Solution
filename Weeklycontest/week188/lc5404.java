package week188;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lc5404 {
    public static List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0, j = 0; i < n; i++) {
            st.push(i + 1);
            if (st.peek() == target[j]) {
                res.add("Push");
                if (++j >= target.length) break;
            } else {
                st.pop();
                res.add("Push");
                res.add("Pop");
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] target = { 2,3,4};
        int[] target1 = {1, 2};
        System.out.println(buildArray(target, 4));
    }




}
