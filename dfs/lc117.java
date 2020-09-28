import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: lc117
 * Package: PACKAGE_NAME
 * Description:
 *
 * @date: 2020/4/8 22:54
 * @author: tooyoung
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 *117. 填充每个节点的下一个右侧节点指针 II
 *
 */

public class lc117 {

    public Node1 connect(Node1 root) {
        if (root == null) {
            return root;
        }
        LinkedList<Node1> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node1 tmp = q.removeFirst();
                if (i == size - 1) {
                    tmp.next = null;
                }else {
                    tmp.next = q.getFirst();
                }

                if (tmp.left != null) {
                    q.add(tmp.left);
                }
                if (tmp.right != null) {
                    q.add(tmp.right);
                }
            }
        }
        return root;
    }

}

class Node1 {
    public int val;
    public Node1 left;
    public Node1 right;
    public Node1 next;

    public Node1() {}

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val, Node1 _left, Node1 _right, Node1 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
