import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 67. 二进制求和
 * https://leetcode-cn.com/problems/add-binary/
 */
public class lc67 {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
//        LinkedList<Integer> res = new LinkedList<>();
        int i = a.length() - 1, j = b.length() - 1;
        // 改成字节数组，提升性能，避免边界检查
        char[] ch1 = a.toCharArray();
        char[] ch2 = b.toCharArray();

        int carr = 0;
        while (i >= 0 || j >= 0) {
//            int c1 = (i >= 0) ? a.charAt(i) - '0' : 0;
            int c1 = (i >= 0) ? ch1[i] - '0' : 0;
            int c2 = (j >= 0) ? ch2[j] - '0' : 0;
            carr = carr + c1 + c2;
//            res.addFirst(carr % 2);
            sb.append(carr % 2);
            carr /= 2;
            i--;
            j--;
        }
        // 不需要
//        while (i >= 0) {
//            carr = carr + a.charAt(i) - '0';
//            res.addFirst(carr % 2);
//            carr = (carr >= 2) ? 1 : 0;
//            i--;
//        }
//        while (j >= 0) {
//            carr = carr + b.charAt(j)  - '0';
//            res.addFirst(carr % 2);
//            carr = (carr >= 2) ? 1 : 0;
//            j--;
//        }
        if (carr > 0) sb.append(carr % 2);;

//        for (int val : res) {
//            sb.append(val);
//        }
        return sb.reverse().toString();
//        return res.toString().substring(1, res.size() - 1).replaceAll(",", "").replaceAll(" ", "");
    }

    public static void main(String[] args) {

    }

}
