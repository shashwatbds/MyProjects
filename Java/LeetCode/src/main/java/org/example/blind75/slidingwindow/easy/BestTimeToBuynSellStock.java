package org.example.blind75.slidingwindow.easy;

import java.time.Duration;
import java.time.Instant;

public class BestTimeToBuynSellStock {

    public static void main(String[] args) {
        BestTimeToBuynSellStock obj = new BestTimeToBuynSellStock();
        System.out.println("Maximum Profit is - "+obj.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println("Maximum Profit is - "+obj.maxProfit(new int[]{7,6,4,3,1}));
    }

    /**
     * We have to find the curr minimum and the next maximum after the current minimum in this case to find maximum profit.
     * Target: Max profit will always be between highest and lowest number in the array,
     *          so you will iterate once and find min number and keep finding difference between the cur min and the curr item in the array.
     *
     *          Pitfall: We can't just find the min and max number in an array since we do not want the min number to exits after the max number, this way we won't make profit.
     * */
    public int maxProfit(int[] prices) {

        Instant start = Instant.now();
        int min = prices[0], maxProfit = 0;

        for(int i=0; i<prices.length; i++) {
            if(prices[i] < min) {
                min = prices[i];
            }

            maxProfit = Math.max(maxProfit, prices[i] - min);
        }

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("time taken to execute " + timeElapsed);
        return maxProfit;
    }
}
