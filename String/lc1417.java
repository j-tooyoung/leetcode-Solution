import java.util.ArrayList;
import java.util.List;

/**
 *1417. 重新格式化字符串
 * https://leetcode-cn.com/problems/reformat-the-string/
 *
 */
public class lc1417 {

    // 有待优化
    public static String reformat(String s) {
        int len = s.length();
        List<Character> dig = new ArrayList<>();
        List<Character> ch = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if ( c>= '0' && c <= '9') {
                dig.add(c);
            } else {
                ch.add(c);
            }
        }
        int digSize = dig.size();
        int chSize = ch.size();
        System.out.println(digSize + " " + chSize);

        if (Math.abs(digSize - chSize) > 1) return "";
        StringBuilder sb = new StringBuilder();
        if (digSize == chSize) {
            for (int i = 0; i < chSize; i++) {
                sb.append(dig.get(i)).append(ch.get(i));
            }
        } else if (digSize > chSize) {
            for (int i = 0; i < chSize; i++) {
                sb.append(dig.get(i)).append(ch.get(i));
            }
            sb.append(dig.get(digSize - 1));
        } else {
            for (int i = 0; i < digSize; i++) {
                sb.append(ch.get(i)).append(dig.get(i));
            }
            sb.append(ch.get(chSize - 1));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "covid2019";
        System.out.println(reformat(s));
    }

}
