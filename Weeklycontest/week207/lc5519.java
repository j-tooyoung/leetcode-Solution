package week207;

/**
 * @Classname lc5519
 * @Description TODO
 * @Date 2020/9/20 10:32
 * @Created by xp123
 * 5519. 重新排列单词间的空格
 * https://leetcode-cn.com/contest/weekly-contest-207/problems/rearrange-spaces-between-words/
 */
public class lc5519 {

    public String reorderSpaces(String text) {
        int num = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                num++;
            }
        }
        if (num == 0) return text;

        String[] split = text.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        int len = split.length;
        if (len == 1) {
            sb.append(split[0]);
            while (num > 0) {
                sb.append(" ");
                num--;
            }
            return sb.toString();
        }
        int avg = num / (len -1);
        int mod = num % (len -1);
        for (int i = 0; i < len; i++) {
            sb.append(split[i]);
            if (i + 1 < len) {
                for (int j = 0; j < avg; j++) {
                    sb.append(" ");
                }
            }
        }
        while (mod > 0) {
            sb.append(" ");
            mod--;
        }

        return sb.toString();
    }

}
