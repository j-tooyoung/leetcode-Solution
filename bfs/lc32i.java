import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName: lc32i
 * Package: PACKAGE_NAME
 * Description:
 *  从上到下打印二叉树
 * @date: 2020/4/8 22:49
 * @author: tooyoung
 */

public class lc32i {


    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return new int[]{};
        q.add(root);
        TreeNode node;
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            node = q.poll();
            list.add(node.val);
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

    }


}
