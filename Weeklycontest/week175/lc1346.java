package week175;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname lc1346
 * @Description
 * @Date 2021/1/2 15:31
 * @Created by j-tooyoung
 */
public class lc1346 {

    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i] << 1) || (arr[i] % 2 == 0 && set.contains(arr[i] >> 1))) {
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }
}
