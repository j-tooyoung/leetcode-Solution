import java.util.*;

/**
 * @Classname lc399
 * @Description
 * @Date 2021/1/6 10:25
 * @Created by j-tooyoung
 */
public class lc399 {

    // bfs
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int nvars = 0;
        double[] res = new double[queries.size()];
        Map<String, Integer> variables = new HashMap<>();
        int n = equations.size();
        for (int i = 0; i < n; i++) {
            if (!variables.containsKey(equations.get(i).get(0))) {
                variables.put(equations.get(i).get(0), nvars++);
            }
            if (!variables.containsKey(equations.get(i).get(1))) {
                variables.put(equations.get(i).get(1), nvars++);
            }
        }
        // 对于每个点，存储其直接连接到的所有点及对应的权值
        List<Pair>[] edges = new List[nvars];
        for (int i = 0; i < nvars; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int va = variables.get(equations.get(i).get(0));
            int vb = variables.get(equations.get(i).get(1));
            edges[va].add(new Pair(vb, values[i]));
            edges[vb].add(new Pair(va, 1.0 / values[i]));
        }
        int queryCount = queries.size();
        for (int i = 0; i < queryCount; i++) {
            List<String> query = queries.get(i);
            double result = -1.0;
            if (variables.containsKey(query.get(0)) && variables.containsKey(query.get(1))) {
                int va = variables.get(query.get(0));
                int vb = variables.get(query.get(1));
                if (va == vb) {
                    result = 1.0;
                } else {
                    Queue<Integer> points = new LinkedList<>();
                    points.offer(va);
                    double[] rations = new double[nvars];
                    Arrays.fill(rations, -1.0);
                    rations[va] = 1.0;
                    while (!points.isEmpty() && rations[vb] < 0) {
                        int x = points.poll();
                        for (Pair pair : edges[x]) {
                            int y = pair.idx;
                            double val = pair.value;
                            if (rations[y] < 0) {
                                rations[y] = rations[x] * val;
                                points.offer(y);
                            }
                        }
                    }
                    result = rations[vb];
                }
            }
            res[i] = result;
        }
        return res;
    }

    class Pair {
        int idx;
        double value;

        public Pair(int idx, double value) {
            this.idx = idx;
            this.value = value;
        }
    }

    //floyd算法 预处理计算两点间的最短距离
    public double[] calcEquation1(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int nvars = 0;
        Map<String, Integer> map = new HashMap<>();
        int n = equations.size();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(equations.get(i).get(0))) {
                map.put(equations.get(i).get(0), nvars++);
            }
            if (!map.containsKey(equations.get(i).get(1))) {
                map.put(equations.get(i).get(1), nvars++);
            }
        }
        //建图
        double[][] graph = new double[nvars][nvars];
        for (double[] doubles : graph) {
            Arrays.fill(doubles, -1.0);
        }
        for (int i = 0; i < n; i++) {
            int va = map.get(equations.get(i).get(0));
            int vb = map.get(equations.get(i).get(1));
            graph[va][vb] = values[i];
            graph[vb][va] = 1.0 / values[i];
        }
        for (int k = 0; k < nvars; k++) {
            for (int i = 0; i < nvars; i++) {
                for (int j = 0; j < nvars; j++) {
                    if (graph[i][k] > 0 && graph[k][j] > 0) {
                        graph[i][j] = graph[i][k] * graph[k][j];
                    }
                }
            }
        }

        int queryCount = queries.size();
        double[] res = new double[queryCount];
        for (int i = 0; i < queryCount; i++) {
            List<String> query = queries.get(i);
            double ans = -1.0;
            if (map.containsKey(query.get(0)) && map.containsKey(query.get(1))) {
                int va = map.get(query.get(0));
                int vb = map.get(query.get(1));
                if (va == vb) {
                    ans = 1.0;
                } else {
                    ans = graph[va][vb];
                }
            }
            res[i] = ans;

        }
        return res;
    }

    // union find todo
    public double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {
        return null;
    }
}
