package algorithms.napsack;

import algorithms.napsack.comparator.ItemProfitWeightRatioComparator;
import algorithms.napsack.model.InputItem;

import java.util.Arrays;
import java.util.Scanner;

public class FractionalNapsack {

    private static final int TOTAL_ITEMS = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner((System.in));
        System.out.println("Enter target weight");
        int targetWeight = scanner.nextInt();

        InputItem[] items = new InputItem[TOTAL_ITEMS];

        for(int i=0; i<TOTAL_ITEMS; i++) {
            System.out.println("Enter item");
            String[] itemDetails = scanner.next().split(",");
            items[i] = new InputItem(Integer.parseInt(itemDetails[0]), Integer.parseInt(itemDetails[1]));
        }
        Arrays.sort(items, new ItemProfitWeightRatioComparator());
        computeMaxWeight(items, targetWeight);
    }

    private static void computeMaxWeight(InputItem[] items, int targetWeight) {

        int currentWeight = targetWeight;

        int totalProfit = 0;
        for(int i=0; i<items.length; i++) {
            if(currentWeight != 0 && (items[i].getWeight() < currentWeight)) {
                totalProfit += items[i].getProfit();
                currentWeight -= items[i].getWeight();
            } else if (currentWeight != 0) {
                totalProfit += (items[i].getProfit()*currentWeight)/items[i].getWeight();
            }
        }
        System.out.println(totalProfit);
    }

}
