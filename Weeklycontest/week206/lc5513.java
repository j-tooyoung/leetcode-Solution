package week206;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Classname lc5024
 * @Description TODO
 * @Date 2020/9/13 9:57
 * @Created by xp123
 * 5513. 连接所有点的最小费用
 * https://leetcode-cn.com/contest/weekly-contest-206/problems/min-cost-to-connect-all-points/
 */

public class lc5513 {
    static int n;
    static int N = 1010;
    static int INF = 0x3f3f3f3f;
    static boolean[] vis = new boolean[N];
    static int[][] graph = new int[N][N];
    static int[] dist = new int[N];

    static int prim() {
        Arrays.fill(dist, INF);
        int res = 0;
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 0; j < n; j++) {
                if (!vis[j] && (t == -1 || dist[j] < dist[t])) {
                    t = j;
                }
            }
            vis[t] = true;
            if (i != 0) res += dist[t];
            for (int j = 0; j < n; j++) {
                dist[j] = Math.min(dist[j], graph[t][j]);
            }
        }
        return res;
    }

    public static int minCostConnectPoints(int[][] points) {

        n = points.length;

        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], INF);
        }
        Arrays.fill(vis, false);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = graph[j][i] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
            }
        }
        int t = prim();
        return t;
    }

}
//public class lc5513 {
//
//
//    public int minCostConnectPoints(int[][] points)  {
////        System.out.println("请输入图有几条边和几个点:");
//        int m = points.length;
//        int n = m * (m - 1) / 2;
////        int n = scn.nextInt();  //保存边数
////        int m = scn.nextInt(); //保存点数
//        Edge edge[] = new Edge[n];
//        int idx = 0;
//        for (int i = 0; i < m; i++) {
//            for (int j = i + 1; j < m; j++) {
//                edge[idx] = new Edge();  //创建出真实的边出来
//                edge[idx].ConnectPoint[0] = i;
//                edge[idx].ConnectPoint[1] = j;
//                edge[idx].v = Math.abs(points[j][0] - points[i][0]) + Math.abs(points[j][1] - points[i][1]);
//                idx++;
//            }
//        }
//
//        //输入完了之后，将这些边按权值进行排序
//        sort(edge);
//
//        //定义一个点的数组，来存放已经选择的边的关联顶点编号
//        int hasSelectPoint[] = new int[2*m];  //因为每条边都有关联两个顶点,选择的边存放进来可能会存放两次
//        //初始化，这个数组开始全部存0，都没有被选择
//        for(int i=0;i<hasSelectPoint.length;i++){
//            hasSelectPoint[i] = 0;
//        }
//
//        //权值排序完成之后就开始选边
//        int j=0;
//        int step = 1;//选的边数，开始选第一条边
//        for(int i=0;i<n;i++){
//            //最小生成树要选的边数等于顶点数-1,那么开始要选m-1最后一条边时这样选。再break退出
//            if(step == m-1 && allInSelectPoint(edge[i],hasSelectPoint)){ //最后一条边了
//                edge[i].isSelect = 1;//直接选择
//                break;
//            }else if(edge[i].isSelect ==0 && !allInSelectPoint(edge[i],hasSelectPoint)){ //如果边没有被选，并且这条边的两个顶点不同时在顶点的数组里
//                edge[i].isSelect = 1;
//                hasSelectPoint[j] = edge[i].ConnectPoint[0];
//                j++;
//                hasSelectPoint[j] = edge[i].ConnectPoint[1];
//                j++;
//                step++; //开始选第二条边
//            }
//        }
//
//        //打印所选的边
//        int sum = 0; // 计算权值
//        System.out.print("所选的边为:");
//        for(int i=0;i<n;i++){
//            if(edge[i].isSelect==1){
//                sum = sum + edge[i].v;
////                System.out.print(edge[i].No + " ");
//            }
//        }
////        System.out.println();
////        System.out.println("权值为: " + sum);
//        return sum;
//    }
//
//
//
//    private static boolean allInSelectPoint(Edge edge, int[] hasSelectPoint) {
//        int flag1 = 0;
//        int flag2 = 0;//这两个变量是分别看边的两个端点在不在存放已经选择点的数组里面
//        for(int i=0;i<hasSelectPoint.length;i++){
//            if(edge.ConnectPoint[0] ==hasSelectPoint[i]){
//                flag1 = 1;
//            }
//            if(edge.ConnectPoint[1] ==hasSelectPoint[i]){
//                flag2 = 1;
//            }
//        }
//        if(flag1 ==1 && flag2 ==1){  //两个点都在
//            return true;
//        }else {  //都不在或者有一个点不在
//            return false;
//        }
//    }
//
//    //将权值进行交换
//    private static void sort(Edge[] edge) {
//        Edge tempEdge = null;
//        for(int i=0;i<edge.length;i++){
//            for(int j=i+1;j<edge.length;j++){
//                if(edge[j].v<edge[i].v){
//                    tempEdge = edge[i];
//                    edge[i] = edge[j];
//                    edge[j] = tempEdge;
//                }
//            }
//        }
//    }
//
//}
//
//
//class Edge{
//    int v; //边的权值
//    int[] ConnectPoint = new int[2];  //边所连接的点
//    int isSelect; //是否被选择，1表示被选，0表示没有被选
//    char No; //图的编号,a,b,c,d...在创建图的时候初始化的
//}
