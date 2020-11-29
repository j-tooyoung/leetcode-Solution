package Week218;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname lc5666
 * @Description
 * @Date 2020/11/15 23:44
 * @Created by j-tooyoung
 */
public class FrontMiddleBackQueue {

    List<Integer> list = new ArrayList<>();

    public FrontMiddleBackQueue() {
        this.list = list;
    }

    public void pushFront(int val) {
        list.add(0, val);
    }

    public void pushMiddle(int val) {
        list.add(list.size() >> 1, val);
        for (Integer v : list) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    public void pushBack(int val) {
        list.add(val);
    }

    public int popFront() {
        if (list == null || list.size() < 1) {
            return -1;
        }
        List<Integer> tmp = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            tmp.add(list.get(i));
        }
        list = tmp;
        int ans = list.get(0);
        return ans;
    }

    public int popMiddle() {
        if (list == null || list.size() < 1) {
            return -1;
        }
        int ans = list.get(list.size() - 1 >> 1);
        List<Integer> tmp = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i <size; i++) {
            if (i == ((size-1) >> 1)) {
                continue;
            }
            tmp.add(list.get(i));
        }
        list = tmp;
        return ans;
    }

    public int popBack() {
        if (list == null || list.size() < 1) {
            return -1;
        }
        int ans = list.get(list.size() - 1);
        List<Integer> tmp = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            tmp.add(list.get(i));
        }
        list = tmp;
        return ans;
    }

}
