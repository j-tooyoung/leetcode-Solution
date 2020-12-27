package Dweek43;

/**
 * @Classname lc5628
 * @Description
 * @Date 2020/12/13 10:36
 * @Created by j-tooyoung
 */
public class lc5621 {


    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        int x = 0, y = 0;
        for (int i = 0; i < n; i++)
            if (students[i] == 1) {x++;}
            else{
                y++;
            }
        for (int i = 0; i < n; i++) {
            if (sandwiches[i] == 1) {
                if (x > 0){ x--;}

                else{ return n - i;}
            } else {
                if (y > 0) {
                    y--;
                } else {
                    return n - i;
                }
            }
        }
        return 0;
//        Queue<Integer> queue = new LinkedList<>();
//        int cnt = 0;
//        for (int j = 0; j < len; j++) {
//            queue.add(students[j]);
//        }
//
//        int i = 0;
//        int count = 0;
//        while (!queue.isEmpty()) {
//            if (i < sandwiches.length && queue.peek() == sandwiches[i]) {
//                i++;
//                queue.poll();
//                cnt++;
//                count = 0;
//            } else {
//                queue.add(queue.poll());
//                count++;
//            }
//            // System.out.println(count + " " + queue.size());
//            if (count == queue.size()) {
//                break;
//            }
//        }
//        return len - cnt;

    }

    public static void main(String[] args) {
        int[] students = {1, 1, 0, 0};
        int[] sand = {0, 1, 0, 1};
    }



}


