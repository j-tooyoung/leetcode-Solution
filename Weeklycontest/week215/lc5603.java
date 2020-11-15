package week215;

import java.util.*;

/**
 * @Classname lc5568
 * @Description 5603. 确定两个字符串是否接近
 * @Date 2020/11/8 22:13
 * @Created by j-tooyoung
 */
public class lc5603 {

    // 字符集相同，然后排序数目相同
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        Set<Integer> set = new HashSet<>();
        // 超时 word1.toCharArray().length
        for (int i = 0; i < word1.toCharArray().length; i++) {

        }
        for (int i = 0; i < word1.length(); i++) {
            set.add(word1.charAt(i) - 'a');
            cnt1[word1.charAt(i) - 'a']++;
            cnt2[word2.charAt(i) - 'a']++;
        }
        List<int[]> list1 = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list1.add(new int[]{i, cnt1[i]});
            list2.add(new int[]{i, cnt2[i]});
        }
        list1.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] nums1, int[] nums2) {
                return nums1[1] - nums2[1];
            }
        });
        list2.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] nums1, int[] nums2) {
                return nums1[1] - nums2[1];
            }
        });
        for (int[] ints : list1) {
            System.out.print(Arrays.toString(ints) + " ");
        }
        System.out.println("----");
        for (int[] ints : list2) {
            System.out.print(Arrays.toString(ints) + " ");
        }
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i)[1] != list2.get(i)[1]) {
                return false;
            } else if (list1.get(i)[1] != 0 && !set.contains(list2.get(i)[0])) {
                return false;
            }
        }

//        Arrays.sort(cnt1);
//        Arrays.sort(cnt2);
//        for (int i = 0; i < 26; i++) {
//            if (cnt1[i] != cnt2[i]) {
//                return false;
//            } else if (!set.contains(i)) {
//                return false;
//            }
//        }
//        for (int i = 0; i < 26; i++) {
//            if (cnt[i] < 0) {
//                return false;
//            }
//        }
        return true;
    }
}
