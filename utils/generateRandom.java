/**
 * 生成随机数组
 */

public class generateRandom {

    static int[] generateRandomArray() {
        //数组最大长度
        int maxSize = 20;
        //数组最大值
        int maxVal = 100;
        int[] nums = new int[(int) (maxSize * Math.random())];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (maxVal * Math.random());
        }
        return nums;
    }

    static void printArray(int[] num) {
        if (num == null) {
            return;
        }
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
    }


}
