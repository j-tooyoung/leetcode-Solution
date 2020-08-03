import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 计数排序适用于在数据范围不大的场景中，并且只能给非负整数排序，对于其他类型的数据，要排序的话要在不改变相对大小的情况下，转成非负整数。
 *
 * 比如数据范围 [-1000, 1000] ，就对每个数据 +1000，转换成非负整数。
 *
 * 计数排序这么强大，但是局限性主要有如下两点：
 *
 * 当数列的最大与最小值差距过大，不适合使用计数排序。
 * 比如 20 个随机整数，范围在 0 - 1 亿之间，这时候使用计数排序需要创建长度为 1 亿的数组，严重浪费空间。
 *
 * 数列元素不是整数，不适合使用
 * https://blog.csdn.net/qq_14855971/article/details/107314667
 *
 */

public class CountingSort {

    public static int[] sort(int[] sorceArraay) {
        if (sorceArraay == null || sorceArraay.length < 2) {
            return sorceArraay;
        }
        int len = sorceArraay.length;
        int min = sorceArraay[0];
        int max = sorceArraay[0];
        for (int val : sorceArraay) {
            min = Math.min(val, min);
            max = Math.min(val, max);
        }
        int diff = max - min;
        int[] count = new int[diff + 1];
        // 每个桶的数目
        for (int val : sorceArraay) {
            count[val - min]++;
        }

        //统计排名
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        // 倒叙遍历数组，保证稳定性
        int[] res = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            int val = sorceArraay[i];
            int index = count[val - min] - 1;
            res[index] = val;
            count[val - min]--;
        }
        return res;
    }

    public static void main(String[] args) {
        int a[] = {3, 4, 2, 1, 4, 4};
        a = CountingSort.sort(a);
        System.out.println(Arrays.toString(a));
    }

}
