package week201;

/**
 * 5484. 找出第 N 个二进制字符串中的第 K 位
 * https://leetcode-cn.com/contest/weekly-contest-201/problems/find-kth-bit-in-nth-binary-string/
 */
public class lc5484 {

    public static char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append("0");
        for (int i = 0; i < n-1; i++) {
            String s = reverseAndInsert(sb);
            sb.append("1").append(s);
        }
        System.out.println(sb.toString());
        return sb.toString().charAt(k - 1);
    }

    private static String reverseAndInsert(StringBuilder sb) {
        String s = sb.toString();
        int len = s.length();
        StringBuilder sb1 = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            int val = 1 - (s.charAt(i)-'0');
            sb1.append(Integer.toString(val));
        }
        System.out.println(sb1.toString());
        return sb1.toString();
    }

    public static void main(String[] args) {
        System.out.println(1 - ' ');
//        System.out.println(findKthBit(4, 11));
//        System.out.println(findKthBit(3, 2));
        System.out.println(findKthBit(2, 2));
    }

}
