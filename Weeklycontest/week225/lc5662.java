package week225;

/**
 * @Classname lc5627
 * @Description
 * @Date 2020/12/13 10:37
 * @Created by j-tooyoung
 */
public class lc5662 {

    public int minCharacters(String a, String b) {
        // 满足a<b的步骤数
        int[] cnta = new int[26];
        int[] cntb = new int[26];
        int lena = a.length();
        int lenb = b.length();

        for (int i = 0; i < a.length(); i++) {
            cnta[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            cntb[b.charAt(i) - 'a']++;
        }
        int need1 = lena+lenb;

        // case1 : a< b 临界'a' -'z' a ['a'-'z)
        for (int i = 0; i < 25; i++) {
            int cnt1 = 0;
            for (int j = i + 1; j < 26; j++) {
                cnt1 += cnta[j];
            }
            for (int j = 0; j <= i; j++) {
                cnt1 += cntb[j];
            }
            need1 = Math.min(need1, cnt1);
        }

        int need2 = lena+lenb;
        // case2 : a> b
        for (int i = 0; i < 25; i++) {
            int cnt1 = 0;
            for (int j = 0; j <= i; j++) {
                cnt1 += cnta[j];
            }
            for (int j = i + 1; j < 26; j++) {
                cnt1 += cntb[j];
            }
            need2 = Math.min(need2, cnt1);
        }
        int need3 = lena+lenb;
        for (int i = 0; i < 26; i++) {
            need3 = Math.min(need3, lenb - cntb[i] + lena - cnta[i]);
        }
        // System.out.println("need1 = " + need1);
        // System.out.println("need2 = " + need2);
        // System.out.println("need3 = " + need3);
        return Math.min(need2, Math.min(need3, need1));
    }

}
