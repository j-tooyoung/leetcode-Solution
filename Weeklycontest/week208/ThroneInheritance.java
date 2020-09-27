package week208;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 5525. 皇位继承顺序
 * https://leetcode-cn.com/contest/weekly-contest-208/problems/throne-inheritance/
 * 树
 */
public class ThroneInheritance {

    Map<String, Tree> map = new HashMap<>();
    Tree root;
    List<String> res = new ArrayList<>();

    public ThroneInheritance(String kingName) {
        root = new Tree(kingName, true );
        map.put(kingName, root);
    }

    public void birth(String parentName, String childName) {
        Tree child = new Tree(childName, true);
        map.put(childName, child);
        Tree parent = map.get(parentName);
        List<Tree> children = parent.getChildren();
        children.add(child);
        parent.setChildren(children);
    }

    public void death(String name) {
        Tree node = map.get(name);
        node.setFlag(false);
    }

    public List<String> getInheritanceOrder() {
         dfs(root);
         return res;
    }

    private void dfs(Tree root) {
        if (root == null) {
            return ;
        }
        if (root.isFlag()) res.add(root.name);
        for (Tree child : root.children) {
            dfs(child);
        }
    }

}


class Tree {
    String name;
    boolean flag;
    List<Tree> children;

    public Tree(String name, boolean flag) {
        this.name = name;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public List<Tree> getChildren() {
        return children;
    }

    public void setChildren(List<Tree> children) {
        this.children = children;
    }

}
