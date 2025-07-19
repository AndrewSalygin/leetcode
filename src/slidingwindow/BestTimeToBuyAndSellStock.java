package slidingwindow;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int currentMin = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < currentMin) {
                currentMin = price;
            }
            int currentProfit = price - currentMin;
            maxProfit = Math.max(maxProfit, currentProfit);
        }
        return maxProfit;
    }
}
