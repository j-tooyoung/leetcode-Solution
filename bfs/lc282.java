import java.util.ArrayList;
import java.util.List;

/**
 * 282. 给表达式添加运算符
 * https://leetcode-cn.com/problems/expression-add-operators/
 */
public class lc282 {

    public static List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        return res;
    }

    public static void main(String[] args) {
        String num = "123";
        System.out.println(addOperators(num, 6).toString());
        String num1 = "232";
        System.out.println(addOperators(num1, 8).toString());
        String num2 = "105";
        System.out.println(addOperators(num2, 5).toString());
        String num3 = "00";
        System.out.println(addOperators(num3, 0).toString());
    }
}
