import java.util.TreeMap;

/**
 * ClassName: BSTIterator
 * Package: PACKAGE_NAME
 * Description:
 *
 * @date: 2020/4/13 10:24
 * @author: tooyoung
 */

public class BSTIterator {

    public BSTIterator(TreeNode root) {

    }

    /** @return the next smallest number */
    public int next() {
        return 0;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return false;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
