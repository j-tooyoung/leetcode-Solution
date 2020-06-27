import java.util.LinkedList;
import java.util.Queue;


/**
 * TreeNode工厂
 */
public class TreeNode_Factory implements TestHelperFactory<TreeNode> {


    @Override
    public TreeNode produce(String s) {
        s = s.replace("[", "");
        s = s.replace("]", "");
        String[] sArr = s.split(",");
        int n = sArr.length;
        Queue<TreeNode> qTree = new LinkedList<TreeNode>();
        TreeNode headNode = new TreeNode(Integer.parseInt(sArr[0]));
        qTree.add(headNode);
        int i = 1;
        while (i < n) {
            TreeNode tempNode = qTree.poll();
            TreeNode left = null;
            String tempString = sArr[i];
            if (!tempString.equals("null")) {
                try {
                    int temp = Integer.parseInt(tempString);
                    left = new TreeNode(temp);
                    tempNode.left = left;
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }

            i++;
            if (i == n) {
                break;
            }
            TreeNode right = null;
            tempString = sArr[i];
            if (!tempString.equals("null")) {
                try {
                    int temp = Integer.parseInt(tempString);
                    right = new TreeNode(temp);
                    tempNode.right = right;
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }

            i++;
            qTree.add(left);
            qTree.add(right);
        }
        return headNode;
    }
}
