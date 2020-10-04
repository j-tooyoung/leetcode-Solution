package Dweek36;


import java.io.Serializable;

import java.util.*;

/**
 * 5516. 警告一小时内使用相同员工卡大于等于三次的人
 * https://leetcode-cn.com/contest/biweekly-contest-36/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/
 */
public class lc5516 {

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        List<pair> pairList = new ArrayList<>();
        for (int i = 0; i < keyName.length; i++) {
            pairList.add(new pair(keyTime[i], keyName[i]));
        }
        Collections.sort(pairList);
//        for (pair pair : pairList) {
//            System.out.println(pair);
//        }
        for (int i = 0; i + 2 < pairList.size(); i++) {
            pair p1 = pairList.get(i);
            pair p2 = pairList.get(i + 2);
            String name1 = p1.name;
            String name2 = p2.name;
            if (name1.equals(name2)) {
                int times = getTime(p2.time) - getTime(p1.time);
                if (times <= 60) {
//                    System.out.println(pairList.get(i + 2) + " " + pairList.get(i));
//                    System.out.println(pairList.get(i + 2).time + " " + pairList.get(i).time);
                    if (!set.contains(name1)) {
                        res.add(name1);
                        set.add(name1);
                    }
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    int getTime(String time) {
        int res = 0;
        res = Integer.valueOf(time.substring(0, 2)) * 60;
        res += Integer.valueOf(time.substring(3));
        return res;
    }

    class pair implements Comparable<pair>, Serializable {

        String time;
        String name;

        public pair(String time, String name) {
            this.time = time;
            this.name = name;
        }


        @Override
        public int compareTo(pair pair) {
            // 错误自定义排序
//            if (this.name.compareTo(pair.name) < 0) {
//                return this.time.compareTo(pair.time);
//            } else if (this.name.compareTo(pair.name) == 0) {
//                return this.time.compareTo(pair.time);
//            } else if (this.name.compareTo(pair.name) > 0) {
//                return 1;
//            }
            if (this.name.compareTo(pair.name) == 0) {
                return this.time.compareTo(pair.time);
            } else {
                return this.name.compareTo(pair.name);
            }
            // 先比较name,再比较time
//            int tmp = this.name.compareTo(pair.name);
//            return tmp == 0 ? this.time.compareTo(pair.time) : tmp;
        }

        @Override
        public String toString() {
            return "pair{" +
                    "time='" + time + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        String s = "11:00";
        String s1 = "11:09";
        lc5516 lc5516 = new lc5516();
        System.out.println(lc5516.getTime(s));
        System.out.println(lc5516.getTime(s1));
        System.out.println("a".compareTo("b"));
        System.out.println("12:00".compareTo("13:03"));

    }
}
//    String t1 = pairList.get(i + 2).time;
//                String t2 = pairList.get(i).time;
////                Date d1 = new Date(t1);
////                Date d2 = new Date(t2);
////                long diff = d1.getTime() - d2.getTime();//这样得到的差值是毫秒级别
////                long days = diff / (1000 * 60 * 60 * 24);
////
////                long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
//                DateFormat df = new SimpleDateFormat("HH:mm");
//                long hours = 0L;
//
//                Date d1 = null;
//                Date d2 = null;
//                try {
//                    d1 = df.parse(t1);
//                     d2 = df.parse(t2);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                long diff = d1.getTime() - d2.getTime();// 这样得到的差值是微秒级别
//                hours = diff / (1000 * 60 * 60);
////                "23:51" - "00:10" 不被视为一小时内，因为系统记录的是某一天内的使用情况。
//                if (hours <= 1) {

