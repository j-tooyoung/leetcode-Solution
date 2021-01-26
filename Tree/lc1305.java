import java.util.ArrayList;
import java.util.List;

/**
 * 1305. 两棵二叉搜索树中的所有元素
 * https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/
 *
 *
 */
public class lc1305 {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer>  list1 = new ArrayList<>();
        List<Integer>   list2 = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        dfs(root1,list1);
        dfs(root2, list2);
        list1.stream().forEach(val -> System.out.print(val + " "));
        int i = 0, j = 0;
        int len1 = list1.size();
        int len2 = list2.size();
        while (i < len1 && j < len2) {

//            int a = i < list1.size() ? list1.get(i) : 0;
//            int b = j < list2.size() ? list2.get(j) : 0;
            if (list1.get(i) < list2.get(j)) {
                res.add(list1.get(i));
                i++;
            } else {
                res.add(list2.get(j));
                j++;
            }
        }
        while (i < len1) {
            res.add(list1.get(i++));
        }
        while (j < len2) {
            res.add(list2.get(j++));
        }
        return res;

    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

}
