/**
 * 258. 各位相加
 * https://leetcode-cn.com/problems/add-digits/
 */
public class lc258 {

    public int addDigits(int num) {
        return helper(num);
    }

    private int helper(int num) {
        if (num >= 0 && num <= 9) {
            return num;
        }
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return helper(res);
    }

    //
    public int addDigits1(int num) {
//        if (num == 0) return 0;
//        if (num % 9 == 0) return 9;
//        return num % 9;
        return (num - 1) % 9 + 1;
    }

    public static void main(String[] args) {
        int n = 40;
        for (int i = 0; i < n; i++) {
            System.out.println(i +","+ new lc258().addDigits(i));
        }
    }
}
