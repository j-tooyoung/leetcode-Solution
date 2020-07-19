import java.util.LinkedList;

/**
 * 682. 棒球比赛
 * https://leetcode-cn.com/problems/baseball-game/
 */
public class lc682 {

//    数字，就是本轮得分
//+，就是本轮得分是前两轮相加
//    D，就是本轮得分是前一轮的两倍
//    C，删掉最后一轮得分
//    除了C是操作以外，其他均是当前该轮的得分，也就是可以把+、D都当成数值的。

    public static int calPoints(String[] ops) {
        LinkedList<Integer> st = new LinkedList<>();
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("C")) {
                st.removeLast();
            } else if (ops[i].equals("D")) {
                st.addLast(st.getLast() * 2);
            } else if (ops[i].equals("+")) {
                int num1 = st.removeLast();
                int num2 = st.removeLast();
                st.addLast(num2);
                st.addLast(num1);
                st.addLast(num1 + num2);
            } else {
                st.addLast(Integer.valueOf(ops[i]));
            }
        }
        int ans = 0;
        for (int val : st) {
            ans += val;
        }
        return ans;
    }

    public static void main(String[] args) {
         StringArr_Factory stringArr_factory = new StringArr_Factory();
         String[] s = stringArr_factory.produce("[\"5\",\"-2\",\"4\",\"C\",\"D\",\"9\",\"+\",\"+\"]");
         String[] s1 = stringArr_factory.produce("[\"5\",\"2\",\"C\",\"D\",\"+\"]");
        System.out.println(calPoints(s));
        System.out.println(calPoints(s1));
    }
}
