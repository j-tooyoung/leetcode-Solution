/**
 *
 */
public class binarySearch {

    static int bs(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    static int bs1(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(bs(arr, 2));
        System.out.println(bs(arr, 4));
        System.out.println(bs1(arr, 4));
        System.out.println(bs1(arr, 2));


    }

}
