// https://leetcode.com/problems/best-time-to-buy-and-sell-stock

class Solution {
    public int maxProfit(int[] p) {
        int n = p.length;

        int currVal = p[0];
        int globalMax = 0;

        for(int i = 1; i < n; i++) {
            int temp = p[i] - currVal;

            globalMax = Math.max(globalMax, temp);
            if(temp < 0) currVal = p[i];
        }

        return globalMax;
    }
}