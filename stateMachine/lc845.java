/**
 * @Classname lc845
 * @Description
 * @Date 2020/11/8 10:18
 * @Created by j-tooyoung
 */
// fixme
public class lc845 {

    public int longestMountain(int[] A) {
        int maxLen = 0, curLen = 0;
        int state = 0;
        for (int i = 1; i < A.length; i++) {
            switch (state) {
                case 1:
                    if (A[i] > A[i - 1]) {
                        curLen++;
                        state = 1;
                    } else if (A[i] == A[i - 1]) {
                        state = 0;
                        curLen = 0;
                    } else {
                        state = 2;
                        curLen++;
                    }
                    break;
                case 2:
                    // 如果正在下坡
                    if (A[i] >= A[i - 1]) {
                        maxLen = Math.max(maxLen, curLen);
                        curLen = (A[i] == A[i - 1]) ? 0 : 1;
                        state = (A[i] == A[i - 1]) ? 0 : 1;
                    } else {
                        curLen++;
                    }
                    break;
                case 0:
                    if (A[i] >= A[i - 1]) {
                        curLen++;
                        state = 1;
                    }
                    break;
                }

        }
        if (state == 2) {
            maxLen = Math.max(maxLen, curLen);
        }
        // 如果最后是以下坡为结尾的，要结算一下

        // 如果不为0，说明结果有效，注意还要加1，因为没把单个元素算上
        return maxLen == 0 ? maxLen : maxLen + 1;
    }
}
