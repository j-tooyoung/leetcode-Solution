import java.util.Arrays;

/**
 * ClassName: lc11
 * Package: PACKAGE_NAME
 * Description:
 * 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * @date: 2020/4/8 22:36
 * @author: tooyoung
 */

public class lc11 {

    //双指针
    public int maxArea(int[] height) {
        int res = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {

            res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

    public int BFmaxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height.length; j++) {
                maxArea = Math.max(maxArea, (j - i) * Math.min(height[j], height[i]));
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        lc11 lc11 = new lc11();
        int[] num = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(lc11.maxArea(num));
        System.out.println(lc11.BFmaxArea(num));

//        boolean right = true;
//        for (int i = 0; i < 1000; i++) {
//            int[] height = generateRandom.generateRandomArray();
//            int[] cp1 = Arrays.copyOf(height, height.length);
//            if (lc11.maxArea(height) != lc11.BFmaxArea(cp1)) {
//                right = false;
//                System.out.println("错误测试例子");
//                generateRandom.printArray(height);
//            }
//        }
//        System.out.println(right ? "通过" : "失败");
    }
}
