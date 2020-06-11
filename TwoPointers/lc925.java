/**
 * 925. 长按键入
 * https://leetcode-cn.com/problems/long-pressed-name/
 * 题解
 * https://leetcode-cn.com/problems/long-pressed-name/solution/chang-an-jian-ru-by-leetcode/
 */
public class lc925 {

    public static boolean isLongPressedName(String name, String typed) {

//        String
        return true;
    }

    public static boolean isLongPressedName1(String name, String typed) {
        int i = 0, j = 0;
        int cnt1, cnt2;
        while (i < name.length() && j < typed.length()) {
            cnt1 = 0;
            cnt2 = 0;
            if (name.charAt(i) == typed.charAt(j)) {
                // 统计相同数目
                while (i + 1 < name.length() && name.charAt(i) == name.charAt(i + 1)) {
                    i++;
                    cnt1++;
                }
                while (j + 1 < typed.length() && typed.charAt(j) == typed.charAt(j + 1)) {
                    j++;
                    cnt2++;
                }
                if (cnt1 > cnt2) {
                    return false;
                }
                //
                i++;
                j++;

            } else {
                return false;
            }
        }
        //无法判断最后一个字符
        return name.charAt(name.length() - 1) == typed.charAt(typed.length() - 1);
    }

    public static void main(String[] args) {
        String name = "alex";
        String name1 = "pyplrz";
        String typed = "aaleex";
        String typed1 = "ppyypllr";
//        System.out.println(isLongPressedName1(name,typed));
        System.out.println(isLongPressedName1(name1, typed1));
//        System.out.println(name1.charAt(5));

    }
}
