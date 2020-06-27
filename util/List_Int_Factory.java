import java.util.ArrayList;
import java.util.List;

/**
 * List工厂
 */

public class List_Int_Factory implements TestHelperFactory<List<Integer>> {
    @Override
    public List<Integer> produce(String s) {
        TestHelperFactory<int[]> factory = new IntArr_One_Factory();
        int[] intArr = factory.produce(s);
        return initialList(intArr);
    }

    public List<Integer> initialList(int[] arr) {
        int n = arr.length;
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}