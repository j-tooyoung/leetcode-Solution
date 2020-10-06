import java.util.PriorityQueue;

/**
 * ClassName: MedianFinder
 * Package: PACKAGE_NAME
 * Description:
 * 295. 数据流的中位数
 * https://leetcode-cn.com/problems/find-median-from-data-stream/
 * 剑指 Offer 41. 数据流中的中位数
 * https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
 * @date: 2020/4/13 10:16
 * @author: tooyoung
 */
//
public class MedianFinder1 {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    private int count;

    /** initialize your data structure here. */
    public MedianFinder1() {
        // 大顶堆
        count = 0;
        maxHeap = new PriorityQueue<>((x, y) -> y - x);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        count++;
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if ((count & 1) == 1) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
//        for (int val : maxHeap) {
//            System.out.println(val);
//        }
//        System.out.println("-----");
//        minHeap.stream().forEach(val -> System.out.println(val));
        if ((count & 1) == 0) {
//            System.out.println(maxHeap.peek() + " " + minHeap.peek());
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return (double) maxHeap.peek();
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
