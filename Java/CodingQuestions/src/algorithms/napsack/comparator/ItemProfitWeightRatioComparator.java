package algorithms.napsack.comparator;

import algorithms.napsack.model.InputItem;

import java.util.Comparator;

public class ItemProfitWeightRatioComparator implements Comparator<InputItem> {
    @Override
    public int compare(InputItem item1, InputItem item2) {
        int ratio1 = item1.getProfit()/item1.getWeight();
        int ratio2 = item2.getProfit()/ item2.getWeight();
        return ratio2-ratio1;
    }
}
