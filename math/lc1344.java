/**
 * @Classname lc1344
 * @Description TODO
 * @Date 2020/8/25 20:53
 * @Created by xp123
 * 1344. 时钟指针的夹角
 * https://leetcode-cn.com/problems/angle-between-hands-of-a-clock/
 *
 */
public class lc1344 {

    public double angleClock(int hour, int minutes) {
        double angleHour = 0;
        double angleMin = 0;
        // 时针走了多少小时
        double h = minutes / 60.0;
        angleHour = ((hour % 12) + h) * 30;
        angleMin = h * 360;
        System.out.println(angleHour + " " + angleMin);
        double diff = Math.abs(angleHour - angleMin);
        return Math.min(diff, 360 - diff);
    }
}
