/**
 * 108. 将有序数组转换为二叉搜索树
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class lc108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if (l > r) return null;
        int mid = l + r >> 1;
        TreeNode  root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, l, mid -1);
        root.right = sortedArrayToBST(nums, mid + 1, r);
        return root;
    }

}
