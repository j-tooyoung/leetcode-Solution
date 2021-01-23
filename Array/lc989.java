import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Classname lc989
 * @Description
 * @Date 2021/1/22 10:18
 * @Created by j-tooyoung
 */
public class lc989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        for (int i = A.length - 1; i >= 0 || K > 0; i--) {
            int a = i >= 0 ? A[i] : 0;
            int b = (K % 10);
            int sum = cnt + a + b;
//            list.add(0, sum % 10);
            list.add(sum % 10);
            cnt = sum / 10;
            K /= 10;
        }
        if (cnt > 0) {
//            list.add(0, cnt);
            list.add(cnt);
        }
        Collections.reverse(list);
        return list;
    }

    public List<Integer> addToArrayForm1(int[] A, int K) {
        List<Integer> res = new ArrayList<Integer>();
        int n = A.length;
        for (int i = n - 1; i >= 0 || K > 0; --i, K /= 10) {
            if (i >= 0) {
                K += A[i];
            }
            res.add(K % 10);
        }
        Collections.reverse(res);
        return res;
    }


}
