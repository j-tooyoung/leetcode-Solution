/**
 * 1071. 字符串的最大公因子
 * https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/
 */
public class lc1071 {


    public static String gcdOfStrings(String str1, String str2) {
        // 假设str1是N个x，str2是M个x，那么str1+str2肯定是等于str2+str1的。
        String res = "";
        if (!(str1 + str2).equals(str2 + str1)) {
            return res;
        }
        int len1 = str1.length();
        int len2 = str2.length();
        return str1.substring(0, gcd(len1, len2));
    }

    public static String gcdOfStrings1(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int len = Math.min(len1, len2);
        String res = "";
        int gcd = gcd(len1, len2);
        if (gcd == 1) {
            return res;
        }

        for (int i = gcd; i >= 0; i += gcd) {
           if (i > len) break;
           String tmp = str1.substring(0, i);
            StringBuilder sub1 = new StringBuilder(str1.substring(0, i));
            StringBuilder sub2 = new StringBuilder(str2.substring(0, i));

//            System.out.println(sub1.equals(sub2));

            if (!sub1.toString().equals(sub2.toString())) {
                return res;
            }
            for (int j = 0; j < len1 / gcd - 1; j++) {
                sub1.append(tmp);
            }
            for (int j = 0; j < len2 / gcd - 1; j++) {
                sub2.append(tmp);
            }
            if (str1.equals(sub1.toString()) && str2.equals(sub2.toString())) {
                return tmp;
            }
        }
        return res;
    }

    private static int gcd(int len1, int len2) {
        if (len1 > len2) {
            return len2 == 0 ? len1 : gcd(len2, len1 - len2);
        } else {
            return len1 == 0 ? len1 : gcd(len1, len2 - len1);
        }
    }

    public static void main(String[] args) {
//        System.out.println(gcd(6, 4));
//        System.out.println(gcd(6, 5));
//        System.out.println(gcd(3, 5));
        String str1 = "ABCABC";
        String str2 = "ABC";
        System.out.println(gcdOfStrings(str1, str2));
    }

}
