package week166;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname lc1282
 * @Description
 * @Date 2021/1/11 10:32
 * @Created by j-tooyoung
 */
public class lc1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            if (map.containsKey(groupSizes[i])) {
                List<Integer> list = map.get(groupSizes[i]);
                list.add(i);
                map.put(groupSizes[i], list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(groupSizes[i], list);
            }
        }

//        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
//            System.out.println(entry.getKey());
//            for (Integer integer : entry.getValue()) {
//                System.out.print(integer +" ");
//            }
//            System.out.println();
//        }
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int size = entry.getValue().size();
            int need = entry.getKey();
            List<Integer> value = entry.getValue();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                list.add(value.get(i));
                if ((i + 1) % need == 0) {
                    res.add(list);
//                    for (Integer integer : list) {
//                        System.out.print(integer +" ");
//                    }
//                    System.out.println();

                    list = new ArrayList<>();
                }
            }
        }
        return res;
    }
}
