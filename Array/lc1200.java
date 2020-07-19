import java.util.*;

/**
 * 1200. 最小绝对差
 * https://leetcode-cn.com/problems/minimum-absolute-difference/
 */
public class lc1200 {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            list.add(new Pair(i, arr[i + 1] - arr[i]));
        }
        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.diff - p2.diff;
            }
        });
        int diff = list.get(0).diff;

        for (Pair p : list) {
            List<Integer> tmp = new ArrayList<>();
            if (p.diff == diff) {
                tmp.add(arr[p.idx]);
                tmp.add(arr[p.idx + 1]);
                res.add(tmp);
            } else {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}

class Pair{
    int idx;
    int diff;


    public Pair(int idx, int diff) {
        this.idx = idx;
        this.diff = diff;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getDiff() {
        return diff;
    }

    public void setDiff(int diff) {
        this.diff = diff;
    }


}
