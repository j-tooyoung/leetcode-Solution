package week117;

import java.util.*;

/**
 * @Classname lc967
 * @Description
 * @Date 2021/1/21 10:50
 * @Created by j-tooyoung
 */
public class lc967 {

    public int[] numsSameConsecDiff1(int n, int k) {
//        fixme 有问题 只能处理加号
        List<Integer> list = new ArrayList<>();
        char[] ch = new char[n];
        char c = '0' + 10;
        for (int i = 0; i < 10; i++) {
            ch[0] = (char) ('0' + i);
            boolean flag = true;
            for (int j = 1; j < n; j++) {
                char c1 = (char) (ch[j - 1] + k);
                if (c1 >= c) {
                    c1 = (char) ((c1 - '0') % k + '0');
                }
                ch[j] = c1;
                if (Math.abs(ch[j - 1] - ch[j]) != k) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                continue;
            }
            String s = new String(ch);
            int num1 = Integer.valueOf(s);
            if (ch[0] != '0') {
                list.add(num1);
            }
        }
        // list.stream().forEach(val -> System.out.print(val + " "));

        return list.stream().mapToInt(value -> value).toArray();
    }

    //
    Set<Integer> res = new HashSet<>();

    public int[] numsSameConsecDiff(int n, int k) {
        for (int i = 1; i < 10; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            list.add(i);
            dfs(n, k, list, 1);
        }
        return res.stream().mapToInt(value -> value).toArray();

    }
    private void dfs(int n, int k,  LinkedList<Integer> arr, int idx) {
        //  for (Integer num : arr) {
        //       System.out.print(num +" ");
        //  }
        //  System.out.println();

        if (idx>n) return;
        if (idx == n) {
            int ans = 0;
            for (Integer num : arr) {
                //   System.out.print(num +" ");
                ans = ans * 10 + num;
            }
            // System.out.println();
            // System.out.println("ans = " + ans);
            res.add(ans);
        }

        if (arr.getLast() + k < 10) {
            arr.add(arr.getLast() + k);
            dfs(n, k, arr, idx + 1);
            arr.removeLast();
        }

        if (arr.getLast() - k >= 0) {
            arr.add(arr.getLast() - k);
            dfs(n, k, arr, idx + 1);
            arr.removeLast();
        }
    }

//    private void dfs(int n, int k, int[] arr, int idx) {
//        Arrays.stream(arr).forEach(value -> System.out.print(value + " "));
//        if (idx > n) return;
//        if (idx == n) {
//            int ans = 0;
//            for (int i = 0; i < n; i++) {
//                ans = ans * 10 + arr[i];
//            }
//            System.out.println("ans = " + ans);
//
//            res.add(ans);
//        }
//
//        if (arr[idx - 1] + k < 10) {
//            arr[idx] = arr[idx - 1] + k;
//            dfs(n, k, arr, idx + 1);
//        }
//
//        if (arr[idx - 1] - k >= 0) {
//            arr[idx] = arr[idx - 1] - k;
//            dfs(n, k, arr, idx + 1);
//        }
//    }



}
