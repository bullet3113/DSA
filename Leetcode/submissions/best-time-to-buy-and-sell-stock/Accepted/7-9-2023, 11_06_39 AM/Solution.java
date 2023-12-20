// https://leetcode.com/problems/best-time-to-buy-and-sell-stock

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int curr_max = 0;
        int global_max = 0;

        for(int i = 1; i < n; i++) {
            curr_max += prices[i] - prices[i - 1];

            global_max = Math.max(curr_max, global_max);
            curr_max = Math.max(0, curr_max);
        }
        return global_max;
    }
}