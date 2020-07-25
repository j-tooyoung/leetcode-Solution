import java.util.*;

/**
 * * 451. 根据字符出现频率排序
 * https://leetcode-cn.com/problems/sort-characters-by-frequency/
 */
public class lc451 {
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());

        maxHeap.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> poll = maxHeap.poll();
            for (int i = 0; i < poll.getValue(); i++) {
                sb.append(poll.getKey());
            }
        }
        return sb.toString();
    }

    public static String frequencySort1(String s) {
        int[] cnt = new int[256];
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - ' ';
//             System.out.println(num);
            cnt[num]++;
        }

        List<string> list = new ArrayList<>();
        for (int i = 0; i < 256; i++) {
            if (cnt[i] > 0){
                list.add(new string(i, cnt[i]));
            }
        }

        list.sort(new Comparator<string>() {
            @Override
            public int compare(string o1, string o2) {
                return o2.cnt - o1.cnt;
            }
        });
        StringBuilder sb = new StringBuilder();

        for (string s1 : list) {
            for (int j = 0;j < s1.cnt; j++) {
                sb.append((char) (s1.i + ' '));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "tree";
        String s1 = "Aabb";
        String s2 = "cccaaa";
        String s3 = "2a554442f544asfasssffffasss";
        String s4 = "his s he a ha he  ha ae";
//        System.out.println('a' - 'A');
        System.out.println(' ' - '0');
//        System.out.println((int) 'z');
//        System.out.println((char) (32 + 'A'));
//        System.out.println(frequencySort(s));
//        System.out.println(frequencySort(s1));
//        System.out.println(frequencySort(s2));
//        System.out.println(frequencySort(s3));
        System.out.println(frequencySort(s4));
    }
}

class string{
    int i;
    int cnt;

    public string(int i, int cnt) {
        this.i = i;
        this.cnt = cnt;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
