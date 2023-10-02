package algorithms.napsack.model;

import java.util.Objects;

public class InputItem {

    int profit, weight;

    public InputItem(int profit, int weight) {
        this.profit = profit;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputItem inputItem = (InputItem) o;
        return profit == inputItem.profit && weight == inputItem.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(profit, weight);
    }
}
