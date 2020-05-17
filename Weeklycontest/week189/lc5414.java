package week189;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 5414. 收藏清单
 * https://leetcode-cn.com/contest/weekly-contest-189/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/
 */
public class lc5414 {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            boolean flag = false;
            for (int j = 0; j < favoriteCompanies.size(); j++) {
                if(j == i) continue;
                // i是j的子集
                if (IsSub(favoriteCompanies.get(i), (favoriteCompanies.get(j)))) {
//                    res.add(i);
                    flag = true;
                    break;
                }
            }
            if (!flag) res.add(i);
        }
        return res;
    }

    private boolean IsSub(List<String> s1, List<String> s2) {
        if (s1.size() > s2.size()) return false;
        Set<String> st = new HashSet<>();
        for (String s : s2) {
            st.add(s);
        }
        for (String s : s1) {
            if (!st.contains(s)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> favoriteCompanies = new ArrayList<>();

    }

}
