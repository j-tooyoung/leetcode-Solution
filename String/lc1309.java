/**
 * 1309. 解码字母到整数映射
 * https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
 *
 */
public class lc1309 {

    //注意char 1对应的ascii码 https://blog.csdn.net/baidu_36327010/article/details/83007046
    public static String freqAlphabets(String s) {
        char[] array = s.toCharArray();
        int len = array.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; ) {
            if (i + 2 < len && array[i + 2] == '#') {
                int tmp = Integer.valueOf(s.substring(i, i + 2));
//                System.out.println(tmp);
//                System.out.println((char) ('a' + tmp - 1));
                sb.append((char) ('a' + tmp - 1));
                i += 3;
            } else {
//                int tmp = Integer.valueOf(array[i]);  // 有问题
                int tmp = s.charAt(i)-'0';
//                System.out.println(tmp);
//                System.out.println((char) ('a' + tmp - 1));
                sb.append((char) ('a' + tmp - 1));
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println((char) ('a' + 9));
//        System.out.println((char) ('a' + 25));
//        System.out.println((char) ('a' + 2));
        System.out.println(Integer.valueOf('1'));
        String s = "10#11#12";
        String s1 = "1326#";
        String s2 = "25#";
        String s3= "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#";
        System.out.println(freqAlphabets(s));
        System.out.println(freqAlphabets(s1));
        System.out.println(freqAlphabets(s2));
        System.out.println(freqAlphabets(s3));
    }
}
