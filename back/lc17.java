import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: lc17
 * Package: PACKAGE_NAME
 * Description:
 * 电话号码组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * @date: 2020/4/8 22:26
 * @author: tooyoung
 */

public class lc17 {

    public static void main(String[] args) {
        final lc17 lc17 = new lc17();
        String s = "23";
        List<String> res = lc17.letterCombinations(s);
        printList(res);
    }

    private static void printList(List<String> res) {
        System.out.print("[");
        for (int i = 0; i < res.size() - 1; i++) {
            System.out.println(res.get(i) + ",");
        }
        System.out.print(res.get(res.size() - 1) + "]");
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        helper(digits);
        return res;
    }

    private void helper(String digits) {

    }

}
