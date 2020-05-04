import java.util.ArrayList;
import java.util.List;

/**
 * 590. N叉树的后序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class lc590 {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        return null;
    }

    public static void main(String[] args) {

    }

}

class Node{
    public int val;
    public List<Node> children;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
