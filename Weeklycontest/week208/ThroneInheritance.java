package week208;

import java.util.*;

/**
 * 5525. 皇位继承顺序
 * https://leetcode-cn.com/contest/weekly-contest-208/problems/throne-inheritance/
 * 树
 */
// fixme
//class ThroneInheritance {
//
//    Map<String, List<String>> map;
//    Set<String> dead;
//
//    String king;
//    List<String> res ;
//
//    public ThroneInheritance(String kingName) {
//        this.king =kingName;
//        dead = new HashSet<>();
//        map = new HashMap<>();
//        map.put(king, new ArrayList<>());
//    }
//
//    public void birth(String parentName, String childName) {
//        map.get(parentName).add(childName);
//        map.put(childName, new ArrayList<>());
//    }
//
//    public void death(String name) {
//        dead.add(name);
//    }
//
//    public List<String> getInheritanceOrder() {
            // 放上面初始化,res多获取数据 这是因为每次调用该函数,res之前错误的结果仍被保存
//        res = new ArrayList<>();
//        dfs(king);
//        return res;
//    }
//
//    private void dfs(String kingName) {
//        // if (kingName == null) return;
//        if (!dead.contains(kingName))res.add(kingName);
//        List<String> child = map.get(kingName);
//        for (String son : child) {
//            dfs(son);
//        }
//    }
//}
//
public class ThroneInheritance {

    Map<String, Tree> map;
    Tree root;
    List<String> res = new ArrayList<>();

    public ThroneInheritance(String kingName) {
        map = new HashMap<>();
        root = new Tree(kingName);
        map.put(kingName, root);
    }

    public void birth(String parentName, String childName) {
        Tree child = new Tree(childName);
        Tree parent = map.get(parentName);
        parent.children.add(child);
        map.put(childName, child);

    }

    public void death(String name) {
        Tree node = map.get(name);
        node.flag = false;
    }

    public List<String> getInheritanceOrder() {
         dfs(root);
         return res;
    }

    private void dfs(Tree root) {
        if (root == null) {
            return ;
        }
        if (root.flag) res.add(root.name);
        for (Tree child : root.children) {
            dfs(child);
        }
    }

}


class Tree {
    String name;
    // 初始化
    boolean flag = true;
    List<Tree> children = new ArrayList<>();


    public Tree(String name) {
        this.name = name;
    }
}

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public boolean isFlag() {
//        return flag;
//    }
//
//    public void setFlag(boolean flag) {
//        this.flag = flag;
//    }
//
//    public List<Tree> getChildren() {
//        return children;
//    }
//
//    public void setChildren(List<Tree> children) {
//        this.children = children;
//    }
