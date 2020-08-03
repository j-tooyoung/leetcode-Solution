/**
 * 415. 字符串相加
 * https://leetcode-cn.com/problems/add-strings/
 */
public class lc415 {

    public String addStrings(String num1, String num2) {
//        char[] ch1 = num1.toCharArray();
//        char[] ch2 = num2.toCharArray();
//        int i = ch1.length - 1, j = ch2.length - 1;
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
//            int v1 = i >= 0 ? ch1[i] - '0' : 0;
//            int v2 = j >= 0 ? ch2[j] - '0' : 0;
            int v1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int v2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            i--;
            j--;
            int total = v1 + v2 + carry;
            sb.append(total % 10);
            carry = total / 10;
        }
        // 进位大于0
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {

    }

}

