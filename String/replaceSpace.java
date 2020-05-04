/**
 * 面试题05. 替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class replaceSpace {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

}
