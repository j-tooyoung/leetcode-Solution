package week194;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 5441. 保证文件名唯一
 * https://leetcode-cn.com/contest/weekly-contest-194/problems/making-file-names-unique/
 */
public class lc5441 {


//    unordered_map<string, int> cnt;
//    unordered_set<string> hash;
//    vector<string> res;
//        for(auto name: names){
//        string succ;
//        int k =0;
//        if(cnt.count(name)) k = cnt[name];
//        while(hash.count(name + succ)){
//            k++;
//            succ = "(" + to_string(k) + ")";
//        }
//        res.push_back(name + succ);
//        cnt[name] = k;
//        hash.insert(name + succ);
//    }
//        return res;

    public static String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        int len = names.length;
        String[] res = new String[len];
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(names[i])) {
                res[i] = names[i];
                map.put(names[i], 1);
            } else {
                String succ = new String();
                int cnt = map.get(names[i]);
                // 这个需
                map.put(names[i], cnt + 1);
                while (map.containsKey(names[i] + succ)) {
                    succ =  "(" + cnt + ")";
                    cnt++;
                }
                res[i] = names[i] + succ;
                map.put(res[i], 1);
            }
        }
        return res;
//        Map<String, Integer> map = new HashMap<>();
//        int len = names.length;
//        String[] res = new String[len];
//        for (int i = 0; i < len; i++) {
//            if (!map.containsKey(names[i])) {
//                res[i] = names[i];
//                map.put(names[i], 1);
//            } else {
//                String succ = new String();
//                int cnt = map.get(names[i]);
//                while (map.containsKey(names[i] + succ)) {
//                    cnt++;
//                    succ =  "(" + cnt + ")";
//                }
//                res[i] = names[i] + succ;
//                map.put(res[i], 1);
//                map.put(names[i], cnt - 1);
//            }
//        }
//        return res;
    }

    public static void main(String[] args) {

        String s = "gta(1)";
//        String[] strings = s.split("()");
        System.out.println();

    }
}
