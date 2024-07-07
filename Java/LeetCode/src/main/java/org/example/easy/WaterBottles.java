package org.example.easy;

public class WaterBottles {

    public int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles;//Will surely be consumed weather or not any bottles are exchanged or not.
        while(numBottles>=numExchange) {
            int newBottles = numBottles/numExchange;
            int remBottles = numBottles%numExchange;
            result+=newBottles;//these will be consumed in next cycle hence add right now.
            numBottles=newBottles+remBottles;//new round of full bottles for next iteration.
        }
        return result;
    }

    public static void main(String[] args) {
        WaterBottles obj = new WaterBottles();
        System.out.println(obj.numWaterBottles(9, 3));
        System.out.println(obj.numWaterBottles(15, 4));
        System.out.println(obj.numWaterBottles(15, 8));
    }
}