/**
 * 1184. 公交站间的距离
 * https://leetcode-cn.com/problems/distance-between-bus-stops/
 *
 */
public class lc1184 {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int forwardDis = 0;
        int backwardDis = 0;
        int n = distance.length;
        if (start == destination) return 0;
        if (start > destination) {
            int tmp = start;
            start = destination;
            destination = tmp;
        }
        for (int i = start; i < destination; i++) {
            forwardDis += distance[i];
        }
        for (int i = destination; i < n; i++) {
            backwardDis += distance[i];
        }
        for (int i = 0; i < start; i++) {
            backwardDis += distance[i];
        }
        return Math.min(forwardDis, backwardDis);
    }

}
