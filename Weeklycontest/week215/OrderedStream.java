package week215;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname lc5567
 * @Description 5601. 设计有序流
 * @Date 2020/11/8 22:12
 * @Created by j-tooyoung
 */
public class OrderedStream {

    String[] list;

    int ptr;

    public OrderedStream(int n) {
        list = new String[n + 1];

        ptr = 1;
    }

    public List<String> insert(int id, String value) {
        List<String> res = new ArrayList<>();
        list[id] = value;

        while (ptr< list.length && list[ptr] != null) {
            res.add(list[ptr]);
            ptr++;
        }
        return res;
    }
}
