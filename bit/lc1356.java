import java.util.*;

/**
 * 1356. 根据数字二进制下 1 的数目排序
 * https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits/
 */
public class lc1356 {

    public int[] sortByBits(int[] arr) {
//        Integer[] sortArr = new Integer[arr.length];
//        for(int i = 0; i < arr.length; i++) {
//            sortArr[i] = arr[i];
//        }
//        Arrays.sort(sortArr, new Comparator<Integer>() {
//            public int compare(Integer a, Integer b) {
//                int binaryCountA = bitof1(a), binaryCountB = bitof1(b);
//                return (binaryCountA == binaryCountB) ? a - b :  binaryCountA - binaryCountB;
//            }
//        });
//        for(int i = 0; i < arr.length; i++) {
//            arr[i] = sortArr[i];
//        }
//        return arr;
        return Arrays.stream(arr).boxed().sorted((a, b) -> Integer.bitCount(a) == Integer.bitCount(b) ? a - b : Integer.bitCount(a) - Integer.bitCount(b)).mapToInt(Integer::intValue).toArray();

//        return Arrays.stream(arr).boxed().sorted(Comparator.comparingInt(i -> Integer.bitCount(i) * 10000 + i)).mapToInt(i -> i).toArray();


    }

    public int[] sortByBits1(int[] arr) {
        List<p> list = new ArrayList<>();
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int cnt = bitof1(arr[i]);
            list.add(new p(i, cnt));
        }
        Collections.sort(list, new Comparator<p>() {
            @Override
            public int compare(p p1, p p2) {
                if (p1.cnt < p2.cnt) {
                    return -1;
                } else {
                    return arr[p1.idx] - arr[p2.idx];
                }
            }
        });
        int i = 0;
        for (p p1 : list) {
            res[i++] = arr[p1.idx];
        }
        return res;
    }

    private int bitof1(int i) {
        int cnt = 0;
        while (i != 0) {
            i &= (i - 1);
            cnt++;

        }
        return cnt;
    }

    public static void main(String[] args) {
         lc1356 lc1356 = new lc1356();
        System.out.println(lc1356.bitof1(377));
        System.out.println(lc1356.bitof1(1107));

    }
}

class p{
    int idx;
    int cnt;

    public p(int idx, int cnt) {
        this.idx = idx;
        this.cnt = cnt;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
