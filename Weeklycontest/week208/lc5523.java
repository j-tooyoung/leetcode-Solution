package week208;

/**
 * 5523. 文件夹操作日志搜集器
 * https://leetcode-cn.com/contest/weekly-contest-208/problems/crawler-log-folder/
 *
 */
public class lc5523 {

    public int minOperations(String[] logs) {
        int depth = 0;
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].equals("../")) {
               if (depth > 0) depth--;
            } else if (logs[i].equals("./")) {

            } else {
                depth++;
            }
        }
        return depth;
    }

    public static void main(String[] args) {

    }
}
