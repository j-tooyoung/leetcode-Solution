package week195;

import java.util.*;

/**
 * 5448. 判断路径是否相交
 * https://leetcode-cn.com/contest/weekly-contest-195/problems/path-crossing/
 */
public class lc5488 {
    public static boolean isPathCrossing(String path) {
        Set<Point> set = new HashSet<>();
        set.add(new Point(0, 0));
        int len = path.length();
        int x = 0, y = 0;
//        for (int i = 0; i < len; i++) {
        for (char ch : path.toCharArray()) {
            if (ch == 'N') {
                y++;
            } else if (ch == 'S') {
                y--;
            } else if (ch == 'E') {
                x++;
            } else {
                x--;
            }
            Point p = new Point(x, y);
            if (set.contains(p)) {
                return true;
            }
            set.add(p);
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "NES";
        String s1 = "NESWW";
        String s2 = "NNSWWEWSSESSWENNW";
        String s3 = "ES";
        System.out.println(isPathCrossing(s));
        System.out.println(isPathCrossing(s1));
        System.out.println(isPathCrossing(s2));

    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
