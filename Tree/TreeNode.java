import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: TreeNode
 * Package: PACKAGE_NAME
 * Description:
 * 很直观地可以理解，输入的String数组是对树结构进行“层序”遍历得到的结果。
 * 以下代码用于构造树结构，并提供printTree用于打印树结构。
 * （将树结构逆时针选择90度显示）
 *
 * @date: 2020/4/14 18:18
 * @author: tooyoung
 */

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    /*
     * construct TreeNode from a array format string, for test cases of LeetCode
     */
    public static TreeNode createTree(String tree) {
        // {1,2,3,4,#,#,#,5,#,6,#,7,#,8}
        String[] ss = tree.split(",");
        return createTree(ss);
    }

    public static TreeNode createTree(String[] tree) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        // 1st one should not be #
        TreeNode root = constructOne(tree[0]);
        q.add(root);
        int idx = 1;
        while (!q.isEmpty()) {

            TreeNode tn = q.poll();
            if (tn == null) {
                continue;
            }
            // construct tn's left&right node
            // when to stop
            if (idx == tree.length) {
                break;
            }
            TreeNode left_ = constructOne(tree[idx]);
            tn.left = left_;
            q.add(left_);
            idx++;
            if (idx == tree.length) {
                break;
            }
            TreeNode right_ = constructOne(tree[idx]);
            idx++;


            tn.right = right_;
            // add to queue
            q.add(right_);
        }

        return root;

    }

    private static void printNode(TreeNode tn, int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append("\t");
        }
        sb.append(tn.val);
        System.out.println(sb.toString());
    }

    public static void printTree(TreeNode root, int indent) {
        if (root == null) {
            return;
        }
//		if (root.left == null && root.right == null) {
//			printNode(root, indent);
//		}
        // right
        printTree(root.right, indent + 1);
        // self
        printNode(root, indent);
        // left
        printTree(root.left, indent + 1);
    }

    public static void printTree(TreeNode root) {
        // right first
        printTree(root, 0);
    }

    private static TreeNode constructOne(String s) {
        if (s.compareTo("#") == 0) {
            return null;
        } else {
            return new TreeNode(Integer.parseInt(s));
        }
    }

    //将数组转换成二叉树，并返回根结点
    private static TreeNode arrayToTree(Integer[] array, int index) {
        TreeNode root = null;
        if (index < array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            root = new TreeNode(value);
            root.left = arrayToTree(array, 2 * index + 1);
            root.right = arrayToTree(array, 2 * index + 2);
            return root;
        }
        return root;
    }


    public static void main(String args[]) {
//        TreeNode tn = createTree("2,#,3,#,4,#,5,#,6");
//        TreeNode tn2 = createTree("1,2,3,4,#,#,#,5,#,6,#,7,#,8");
////        printTree(tn);
//        printTree(tn2);
        Integer[] arr = {3, 9, 20, 8, null, 15, 7};
        TreeNode root = arrayToTree(arr, 0);
        printTree(root);

    }

}
