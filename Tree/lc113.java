import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 * https://leetcode-cn.com/problems/path-sum-ii/
 */

public class lc113 {
//    List<List<Integer>> res = new ArrayList<>();
//    List<Integer> path = new ArrayList<>();
//   public  List<List<Integer>> pathSum(TreeNode root, int sum) {
//       dfs(root, sum);
//       return res;
//   }
//
//    void dfs(TreeNode root, int sum ) {
//       if (root == null) return;
//        path.add(root.val);       // 顺序
//
//       if (root.left == null && root.right == null && root.val == sum) {
//           res.add(new ArrayList<>(path));
//        //    return;
//       }
//       dfs(root.left, sum - root.val);
//       dfs(root.right, sum - root.val);
//       path.remove(path.size() - 1);
//   }


    List<List<Integer>> res = new ArrayList<>();

    public  List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum, new ArrayList<>());
        return res;
    }

    void dfs(TreeNode root, int sum, List<Integer> path) {
        if (root == null) return;
        sum -= root.val;
        path.add(root.val);

        if (root.left == null && root.right == null && 0 == sum) {
            res.add(new ArrayList<>(path));
            // return; 错误
            // [[5,4,11,2],[5,4,8,4,5]]
            //[[5,4,11,2],[5,8,4,5]]

        }
        dfs(root.left, sum, path);
        dfs(root.right, sum, path);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode_Factory treeNode_factory = new TreeNode_Factory();
        TreeNode node = treeNode_factory.produce("[5,4,8,11,null,13,4,7,2,null,null,5,1]");
        TreeOperation.show(node);

        List<List<Integer>> tmp = pathSum(node, 22);
        System.out.println(tmp.size());
        for (List<Integer> t : tmp) {
            for (int val : t) {
                System.out.print(val + " ");
            }
            System.out.println("");
        }
    }

}
