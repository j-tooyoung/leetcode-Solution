package week216;

/**
 * @Classname lc5566
 * @Description
 * https://leetcode-cn.com/problems/check-if-two-string-arrays-are-equivalent/
 * 5605. 检查两个字符串数组是否相等
 *
 * @Date 2020/11/15 23:44
 * @Created by j-tooyoung
 */
public class lc5605 {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (String s : word1) {
            sb1.append(s);
        }
        for (String s : word2) {
            sb2.append(s);
        }
        return sb1.toString().equals(sb2.toString());
    }

}
