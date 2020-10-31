package Dweek38;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Classname lc5544
 * @Description
 * @Date 2020/10/18 20:13
 * @Created by j-tooyoung
 */
public class lc5539 {

    public int[] frequencySort(int[] nums) {
        int[] cnt = new int[220];
        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i] + 100]++;
        }
        List<pair> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            pair pair = new pair(cnt[nums[i] + 100], nums[i]);
            list.add(pair);
        }
        Collections.sort(list);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i).val;
        }
        return nums;
    }

    class pair implements Comparable<pair> {
        int num;
        int val;

        public pair(int num, int val) {
            this.num = num;
            this.val = val;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        @Override
        public int compareTo(pair p) {
            if (this.num == p.num) {
                return p.val - this.val;
            }else{
                return this.num - p.num;
            }
        }
    }

    public static void main(String[] args) {

    }
}
