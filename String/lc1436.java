import java.util.ArrayList;
import java.util.List;

/**
 * 1436. 旅行终点站
 * https://leetcode-cn.com/problems/destination-city/
 */
public class lc1436 {

    public String destCity(List<List<String>> paths) {
        String res = null;
        res = paths.get(0).get(1);
        while (true) {
            boolean flag = false;
            for (int j = 0; j < paths.size(); j++) {
                if (res.equals(paths.get(j).get(0))) {
                    System.out.println(paths.get(j).get(0));
//                if (res == paths.get(j).get(0)) { 错误

                    flag = true;
                    res = paths.get(j).get(1);
                    break;
                }
            }
            if (!flag) break;
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> paths = new ArrayList<>();

    }
}
