import java.util.ArrayList;
import java.util.List;

/**
 * https://www.cnblogs.com/JohnTeslaaa/p/12573075.html
 */
public class lc17_1 {

    public static int[] printNumbers(int n) {

        List<Integer> res = new ArrayList<>();
        int idx = 1;
        while (true) {
            if (String.valueOf(idx).length() <= n) {
                res.add(idx);
                idx++;
            } else {
                break;
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();

//        ans = res.toArray(new Integer[0]);
//        return ans;
    }

    public static void main(String[] args) {

    }

}
