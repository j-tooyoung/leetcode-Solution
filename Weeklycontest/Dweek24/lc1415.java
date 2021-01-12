package Dweek24;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname lc1415
 * @Description
 * @Date 2021/1/12 17:44
 * @Created by j-tooyoung
 */
public class lc1415 {
    String ans ="";
    int cnt =0;
    public String getHappyString(int n, int k) {
        cnt =k;
        char[] ch = {'a', 'b', 'c'};
        List<Character> path = new ArrayList<>();
        dfs(ch,n, path);
        return ans;
    }

    private boolean dfs(char[] ch, int n,List<Character> path) {
        if (path.size() == n) {
            cnt--;
            if (cnt <= 0) {
                System.out.println(true);
                StringBuilder sb = new StringBuilder();
                for (Character character : path) {
                    sb.append(character);
                }
                ans = sb.toString();
                return true;
            }

            System.out.println(cnt);
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (path.isEmpty() || ch[i] != path.get(path.size() - 1)) {
                path.add(ch[i]);
                if (dfs(ch, n, path)) {
                    return true;
                }
                path.remove(path.size() - 1);
            }
        }
        return false;
    }
}
