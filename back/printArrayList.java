import java.util.List;

/**
 * ClassName: printArrayList
 * Package: PACKAGE_NAME
 * Description:
 *
 * @date: 2020/4/11 21:15
 * @author: tooyoung
 */

public class printArrayList<T> {


    public  void printArrayList(List<List<T>> res) {
        System.out.println("[");
        for (List<T> ls : res) {
            System.out.print("  [");
            for (int i = 0; i < ls.size() - 1; i++) {
                System.out.print(ls.get(i) + ",");
            }
            System.out.print(ls.get(ls.size() - 1) + "]\n");
        }
        System.out.println("]");
    }


}
