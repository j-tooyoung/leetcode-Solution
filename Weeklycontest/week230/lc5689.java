package week230;

import java.util.List;

/**
 * @Classname lc5628
 * @Description
 * @Date 2020/12/13 10:36
 * @Created by j-tooyoung
 */
public class lc5689 {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans = 0;
        int idx = 0;
        if (ruleKey.equals("type")) {
            idx = 0;
        } else if (ruleKey.equals("color")) {
            idx = 1;
        } else {
            idx = 2;
        }


        System.out.println("idx = " + idx);

        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).get(idx) + " " + ruleValue);
            System.out.println(items.get(i).get(idx) == ruleValue);

            if (items.get(i).get(idx).equals(ruleValue)) {
                ans++;
            }
        }
        return ans;
    }

}


