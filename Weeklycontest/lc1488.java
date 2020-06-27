import java.util.ArrayList;
import java.util.List;

/**
 * 1488. 避免洪水泛滥
 * https://leetcode-cn.com/problems/avoid-flood-in-the-city/
 *
 */
public class lc1488 implements TextInterface<int[], int[]> {


    @Override
    public int[] testTask(int[] input) {
        return avoidFlood(input);
    }

    @Override
    public List<String[]> getOriginalCase() {
        List<String[]> list = new ArrayList<>();
        addToList(list, "[1,2,0,3,0,3,0,0,3,3,3,0]", "");
        addToList(list, "[1,2,0,0,2,1]", "[-1,-1,2,1,-1,-1]");
        addToList(list, "[1,2,3,4]", "[-1,-1,-1,-1]");
        addToList(list, "[1,2,0,1,2]", "[]");
        addToList(list, "[69,0,0,0,69]", "[-1,69,1,1,-1]");
        addToList(list, "[10,20,20]", "");
        addToList(list, "[0,1,1]", "");
        addToList(list, "[1,0,2,0,2,1]", "[-1,1,-1,2,-1,-1]");
        addToList(list, "[1,0,2,3,0,1,2]", "[-1,1,-1,-1,2,-1,-1]");
        addToList(list, "[2,3,0,0,3,1,0,1,0,2,2]", "[]");
        return list;
    }

    public int[] avoidFlood(int[] rains) {
        return null;
    }

    public static void main(String[] args) {

    }
}
