package org.example.blind75.medium;

import java.util.Arrays;

/**
 * Dynamic Programming
 * */
public class CoinChange {

    public static void main(String[] args) {
        CoinChange obj = new CoinChange();
        System.out.println(obj.coinChange(new int[]{1,2,5}, 11));
        System.out.println(obj.coinChange(new int[]{2}, 3));
        System.out.println(obj.coinChange(new int[]{1}, 0));
        System.out.println(obj.coinChange(new int[]{1,3,5,6}, 8));
    }

    public int coinChange(int[] coins, int amount) {

        int[] amt = new int[amount+1];//This array will store minimum number of coins needed to generate a particular value at that index.
        //Why size is 1 greater than the amount actually needed to be generated -
                //because we will also store value needed to calculate 0 amount, that's why extra 1 space is needed.

        Arrays.fill(amt, amount+1);//If we can not create value then we will return -1.
        amt[0] = 0;//The number of coins needed to generate value 0 is 0.

        for(int i=1; i <= amount; i++) {//Since we already know the first element value.
            for(int j=0; j<coins.length; j++) {//Iterate over the input array.
                if(i >=coins[j]) {//Since amount greater than the current coin value (count[j]) can not be used.
                    amt[i] = Math.min(amt[i], 1+ amt[i-coins[j]]);//i will always be greater than equal to j due to the if condition we have above.
                    // initially when default value will be populated then we will simply replace it with whatever value comes less than default value, in next iteration we will could update if new value is less than the previous one.
                }
            }
        }
        if(amt[amount] < amount+1) {//If current value is different from the default value then we can generate this value using coins we have and we must return that.
            return amt[amount];
        }
        return -1;// If the given value can not be generated using the coins then we return -1.
    }
}
