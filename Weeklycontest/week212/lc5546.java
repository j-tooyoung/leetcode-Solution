package week212;

/**
 * @Classname lc5540
 * @Description
 * @Date 2020/10/18 20:12
 * @Created by j-tooyoung
 */
public class lc5546 {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char res = keysPressed.charAt(0);
        int maxVal = releaseTimes[0];
        for (int i = 1; i < releaseTimes.length; i++) {
            int diff = releaseTimes[i] - releaseTimes[i - 1];
            if (maxVal < diff || (maxVal == diff && keysPressed.charAt(i) > res)) {
                res = keysPressed.charAt(i);
                maxVal = diff;
            }
//            if (maxVal < diff) {
//                res = keysPressed.charAt(i);
//                maxVal = diff;
//            } else if (maxVal == diff) {
//                if (keysPressed.charAt(i) > res) {
//                    res = keysPressed.charAt(i);
//                }
//            }

        }
        return res;
    }

}
