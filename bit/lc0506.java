/**
 * 面试题 05.06. 整数转换
 * https://leetcode-cn.com/problems/convert-integer-lcci/
 *
 */
public class lc0506 {

    public static int convertInteger(int A, int B) {
        //想想异或表示什么。如果你把a异或b，那么结果中哪里是1？哪里是0？
        // 不相同为1
        int res = A ^ B;
        int cnt = 0;
        while (res != 0) {
            res &= (res - 1);
            cnt++;
        }
        return cnt;
    }

    public static int convertInteger1(int A, int B) {

        // 1,2 出错
        String a = Integer.toBinaryString(A);
        String b = Integer.toBinaryString(B);
        String tmp = "0000000000000000000000000000000000000000000000000000000000000000";
        a = tmp.substring(0, 32-a.length()) + a;
        b = tmp.substring(0, 32-b.length()) + b;

        System.out.println(a + "," + b);
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(convertInteger1(1, 2));
        System.out.println(convertInteger1(29, 15));

    }
}
