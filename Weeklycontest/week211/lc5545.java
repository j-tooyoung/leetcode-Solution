package week211;

import java.util.Arrays;
import java.util.Comparator;

public class lc5545 {
//[1,3,5,10,15]
//        [1,2,3,4,5]
//        [4,5,6,5]
//        [2,1,2,1]
//        [1,2,3,5]
//        [8,9,10,1]
//        [9,2,8,8,2]
//        [4,1,3,3,5]
    public static int bestTeamScore(int[] scores, int[] ages) {
        int len = scores.length;
        people[] people = new people[len];
        for (int i = 0; i < len; i++) {
            people[i] = new people(scores[i], ages[i]);
//            people[i].score = scores[i];
//            people[i].age = ages[i];
        }
        Arrays.sort(people, new Comparator<people>() {
            @Override
            public int compare(people p1, people p2) {
                if (p1.score < p2.score) {
                    return -1;
                } else if (p1.score == p2.score) {
                    return p1.age - p2.age;
                }
                return 1;
            }
        });
        for (people p : people) {
            System.out.println(p);
        }
//        [9,2,8,8,2]
//[4,1,3,3,5]
        int ans = 0;
        int[] dp = new int[len];
        dp[0] = people[0].score;
        for (int i = 0; i < len; i++) {
            dp[i] = people[i].score;
            for (int j = 0; j < i; j++) {
                if (people[j].age <= people[i].age) {
                    dp[i] = Math.max(dp[j] + people[i].score, dp[i]);
                }
            }
            System.out.println(dp[i]);
            ans = Math.max(ans, dp[i]);
        }
//        for (int i = 0; i < len; i++) {
//            int idx = i;
//            int total = people[idx].score;
//            while (idx + 1 < len && people[idx].age <= people[idx + 1].age) {
//                total += people[idx + 1].score;
//                idx++;
//            }
//            ans = Math.max(total, ans);
//        }
        return ans;
    }

    static class people {
        int score;
        int age;

        public people(int score, int age) {
            this.score = score;
            this.age = age;
        }

        @Override
        public String toString() {
            return "people{" +
                    "score=" + score +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        int[] scores = {1, 3, 5, 10, 15};
        int[] ages = {1, 2, 3, 4, 5};
        System.out.println(bestTeamScore(scores, ages));
    }
}


