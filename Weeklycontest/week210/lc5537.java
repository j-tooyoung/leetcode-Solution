package week210;

/**
 * @Classname lc5136
 * @Description 5537. 分割两个字符串得到回文串
 * https://leetcode-cn.com/contest/weekly-contest-210/problems/split-two-strings-to-make-palindrome/
 * @Date 2020/10/4 13:54
 * @Created by j-tooyoung
 */
public class lc5537 {
    //
//    "x"
//            "y"
//            "xbdef"
//            "xecab"
//            "cdeoo"
//            "oooab"
    //找到a左和b右首个不能构成回文的位置i,j
//a、b中的i,j范围内看是否是回文
    public  boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    private  boolean check(String a, String b) {
        int i = 0, j = a.length() - 1;
        int len = a.length();
        while (i < j) {
            if (a.charAt(i) != b.charAt(j)) {
                break;
            }
            i++;
            j--;
        }
        return isValid(a, i, j) || isValid(b, i, j);
    }


    private  boolean isValid(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
//    public static boolean checkPalindromeFormation1(String a, String b) {
//
//        int len = a.length();
//// 错误
////        if (isValid(a) || isValid(b)) {
////            return true;
////        }
////        int st = 0;
////        while (st < len && a.charAt(st) == b.charAt(len - 1 - st)) {
////            st++;
////        }
////        int st2 = 0;
////        while (st2 < len && b.charAt(st2) == a.charAt(len - 1 - st2)) {
////            st2++;
////        }
////        st = Math.max(st, st2);
//        for (int i = 0;  i < len; i++) {
////            if (isValid(cha, chb, i)) {
//            if (isValid(a, b, i) ) {
//
////                System.out.println(i);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private static boolean isValid(String a, String b, int i) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(a.substring(0, i)).append(b.substring(i ));
//        String tmp = sb.toString();
//        System.out.println(i + " " + tmp);
//        if (isValid(tmp)) {
//            return true;
//        }
//        sb = new StringBuilder();
//        sb.append(b.substring(0, i)).append(a.substring(i ));
//        tmp = sb.toString();
//        System.out.println(i + " " + tmp);
//        if (isValid(tmp)) {
//            return true;
//        }
//        return false;
//    }
//
//    private static boolean isValid(String tmp) {
//        int i = 0, j = tmp.length() - 1;
//        while (i < j) {
//            if (tmp.charAt(i) != tmp.charAt(j)) {
//                return false;
//            }
//            i++;
//            j--;
//        }
//        return true;
//    }

//    private static boolean isValid(char[] cha, char[] chb, int i) {
////        int len = cha.length - 1;
////        int s1 = 0;
////        int s2 = len;
////        boolean flag = true;
////        while (s1 <= i && s2 >= i) {
////            if (cha[s1] != chb[s2]) {
////                flag = false;
////                break;
////            }
////            s1++;
////            s2--;
////        }
//////        System.out.println(flag);
////        if (flag) return true;
////        flag = true;
////        s1 = len;
////        s2 = 0;
////        while (s1 > i && s2 < i) {
////            if (cha[s1] != chb[s2]) {
////                flag = false;
////                break;
////            }
////            s1--;
////            s2++;
////        }
//////        System.out.println(s1 + " " + s2);
////        if (flag) return true;
////        else return false;
//    }


    public static void main(String[] args) {
        String a = "xbdef";
        String b = "xecab";
//        System.out.println(checkPalindromeFormation(a, b));
//        System.out.println(checkPalindromeFormation("aejbaalflrmkswrydwdkdwdyrwskmrlfqizjezd", "uvebspqckawkhbrtlqwblfwzfptanhiglaabjea"));
//        System.out.println(isValid("pvhmzbezspnnpszebzmhvp"));
//        System.out.println(isValid("pvhzbezspnnpszebzmhvp"));
//        System.out.println(isValid("aejbaal"));
//        System.out.println("pvhmupgqeltozftlmfjjde".substring(0, 5));
    }
}
