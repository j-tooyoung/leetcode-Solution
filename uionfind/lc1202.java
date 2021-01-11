import java.util.*;

/**
 * @Classname lc1202
 * @Description
 * @Date 2021/1/11 10:14
 * @Created by j-tooyoung
 */
public class lc1202 {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UF uf = new UF(s.length());
        for (List<Integer> pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }
        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int pa = uf.find(i);
            if (!map.containsKey(pa)) {
                map.put(pa, new ArrayList<Character>());
            }
            map.get(pa).add(s.charAt(i));
        }
        for (Map.Entry<Integer, List<Character>> entry : map.entrySet()) {
            Collections.sort(entry.getValue(), new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    return o2 - o1;
                }
            });
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int x = uf.find(i);
            List<Character> list = map.get(x);
            // 删除末尾最快
            sb.append(list.remove(list.size() - 1));
        }
        return sb.toString();
    }
}

class UF {
    int parent[];
    int rank[];

    int n;

    public UF(int n) {
        this.n = n;
        parent = new int[n];
        rank = new int[n];
        Arrays.fill(rank,1);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }

    public void union(int x, int y) {
        int fx = find(x), fy = find(y);
        if (fx == fy) {
            return;
        }
        if (rank[fx] < rank[fy]) {
            int tmp = fx;
            fx = fy;
            fy = tmp;
        }
        rank[fx] += rank[fy];
        parent[fy] = fx;
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
