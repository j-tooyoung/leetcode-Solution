import java.util.Stack;

/**
 * 1299. 将每个元素替换为右侧最大元素
 * https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side/
 *
 */
public class lc1299 {
    public int[] replaceElements(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i + 1; j < arr.length; j++) {
                max = Math.max(max, arr[j]);
            }
            if (i == arr.length - 1) {
                arr[i] = -1;
            } else {
                arr[i] = max;
            }
        }
        return arr;
    }

    public int[] replaceElements1(int[] arr) {
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                max = Math.max(max, arr[j]);
//            }
//            if (i == arr.length - 1) {
//                arr[i] = -1;
//            } else {
//                arr[i] = max;
//            }
//        }
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        int[] res = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {

        }
        return arr;
    }

}
