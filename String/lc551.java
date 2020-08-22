/**
 * 551. 学生出勤记录 I
 * https://leetcode-cn.com/problems/student-attendance-record-i/
 */
public class lc551 {

    public boolean checkRecord(String s) {
        int len = s.length();
        int cntA = 0;
        int cntL = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'A') {
                cntA++;
                if (cntA > 1) return false;
                cntL = 0;
            } else if (s.charAt(i) == 'L') {
                cntL++;
                if (cntL > 2) return false;
            } else {
                cntL = 0;
            }
        }
        return true;
    }

}
