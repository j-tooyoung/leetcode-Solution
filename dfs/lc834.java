/**
 * @Classname lc834
 * @Description
 * 834. 树中距离之和
 * https://leetcode-cn.com/problems/sum-of-distances-in-tree/
 *
 * @Date 2020/10/6 0:30
 * @Created by j-tooyoung
 */
public class lc834 {

    // 方法一：树形动态规划
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        int len = edges.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
        }
        return res;
    }

    // 暴力法会超时
//    思路：用dfs将无根树化为有根树。在dfs过程中，记录每个节点u的父节点。
//
//    之后，在计算节点u和节点v的距离d时，先找出节点u和v的最近公共祖先p。距离d等于节点u到p的距离和节点v到p的距离之和。
//
//    用邻接链表表示无向图。利用输入的边表edges节省内存。
//
//    作者：jason-2
//    链接：https://leetcode-cn.com/problems/sum-of-distances-in-tree/solution/liang-chong-jie-fa-by-jason-2-69/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    int sum;
    public int[] sumOfDistancesInTree1(int N, int[][] edges) {
//        int len = edges.length;
//        int[] res = new int[len];
//        for (int i = 0; i < len; i++) {
//            sum = 0;
//            dfs(i, edges,  0);
//            res[i] = sum;
//        }
//        return res;
        return null;
    }

    private void dfs(int i, int[][] edges,  int idx) {
//        if (idx == edges.length) {
//            return ;
//        }
//        for (int j = 0; j < edges.length; j++) {
//            if (edges[j][0] == i) {
//                // ?
//                sum++;
//                dfs(edges[j][1], edges, idx + 1);
//            }
//        }
    }


}
