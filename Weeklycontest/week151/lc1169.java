package week151;

import java.util.*;

/**
 * @Classname lc1169
 * @Description
 * @Date 2021/1/20 17:01
 * @Created by j-tooyoung
 */
public class lc1169 {

    // fixme error 有错误
    public List<String> invalidTransactions(String[] transactions) {
//        List<String> res = new ArrayList<>();
//        Map<String, TreeSet<People>> map = new HashMap<>();
//        Map<People, TreeSet<People>> dataMap = new HashMap<>();
//
//        for (int i = 0; i < transactions.length; i++) {
//            String transaction = transactions[i];
//            String[] s = transaction.split(",");
//            String name = s[0];
//            int time = Integer.valueOf(s[1]);
//            int amount = Integer.valueOf(s[2]);
//            String city = s[2];
//            if (amount > 1000) {
//                res.add(transaction);
//            } else {
//                // 出现在不同城市
//                People people = new People(name, city, time, amount);
//                if (map.containsKey(name)) {
//                    TreeSet<People> set = dataMap.get(name);
//                    int first = set.first().time;
//                    int last = set.last().time;
//                    if (Math.abs(first - time) <= 60 || Math.abs(last - time) <= 60) {
//                        res.add(transaction);
//                    }
//                    set.add(people);
//                } else {
//                    TreeSet<People> set = new TreeSet<>();
//                    set.add(people);
//                    map.put(name, set);
//                }
//            }
//        }
//        return res;
        return null;
    }

    class People implements Comparable<People> {



        String name;
        String city;
        int time;
        int amount;

        public People(String name, String city, int time, int amount) {
            this.name = name;
            this.city = city;
            this.time = time;
            this.amount = amount;
        }



        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            People people = (People) o;

            if (name != null ? !name.equals(people.name) : people.name != null) return false;
            return city != null ? city.equals(people.city) : people.city == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (city != null ? city.hashCode() : 0);
            return result;
        }

        @Override
        public int compareTo(People o) {
            return time - o.time;
        }
    }


}
