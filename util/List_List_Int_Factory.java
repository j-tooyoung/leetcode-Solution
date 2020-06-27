import java.util.ArrayList;
import java.util.List;

/**
 * 二维list工厂
 *
 */
public class List_List_Int_Factory implements TestHelperFactory<List<List<Integer>>> {
    @Override
    public List<List<Integer>> produce(String s) {
        TestHelperFactory<int[][]> factory = new IntArr_Two_Factory();
        int[][] intArr = factory.produce(s);
        return initialList(intArr);
    }

    private List<List<Integer>> initialList(int[][] arr) {
        List<List<Integer>> res = new ArrayList<>();
        int n = arr.length;
        List_Int_Factory factory = new List_Int_Factory();
        for (int i = 0; i < n; ++i) {
            int[] temp = arr[i];
            List<Integer> l = factory.initialList(temp);
            res.add(l);
        }
        return res;
    }
}
