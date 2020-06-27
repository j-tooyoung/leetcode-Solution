import java.util.ArrayList;
import java.util.List;

/**
 * 842. 将数组拆分成斐波那契序列
 * https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence/
 */
public class lc842 {

    public static List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        return res;
    }

    public static void main(String[] args) {
        String s = "123456579";
        String s1 = "11235813";
        String s2 = "112358130";
        String s3 = "0123";
        String s4 = "1101111";
        System.out.println(splitIntoFibonacci(s).toString());
        System.out.println(splitIntoFibonacci(s1).toString());
        System.out.println(splitIntoFibonacci(s2).toString());
        System.out.println(splitIntoFibonacci(s3).toString());
        System.out.println(splitIntoFibonacci(s4).toString());
    }
}
