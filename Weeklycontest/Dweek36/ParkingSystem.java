package Dweek36;


/**
 * 5515. 设计停车系统
 * https://leetcode-cn.com/contest/biweekly-contest-36/problems/design-parking-system/
 */
public class ParkingSystem {

    int[] park = new int[3];


    public ParkingSystem(int big, int medium, int small) {
        park[0] = big;
        park[1] = medium;
        park[2] = small;
    }

    public boolean addCar(int carType) {
        if (park[carType - 1] > 0) {
            park[carType - 1]--;
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

    }

}
