import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ClassName: lc295
 * Package: PACKAGE_NAME
 * Description:
 * 295. 数据流的中位数
 * https://leetcode-cn.com/problems/find-median-from-data-stream/
 *
 * @date: 2020/4/8 23:09
 * @author: tooyoung
 */

public class MedianFinder {

    List<Integer> list;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
    }

    public double findMedian() {
        Collections.sort(list);
        int size = list.size();

        return (list.get(size >> 1) + list.get((size - 1) >> 1)) / 2.0;

    }

    public static void main(String[] args) {

    }
}
