// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int i = 1;
        int j = 500;

        while(i < j) {

            int mid = i + (j - i) / 2;

            int daysElapsed = 0;
            int capacity = mid;
            boolean isPossible = true;
            daysElapsed++;
            for(int k = 0; k < weights.length; k++) {
                if(capacity >= weights[k]) {
                    capacity -= weights[k];
                } else {
                    daysElapsed++;
                    capacity = mid - weights[k];
                    if(capacity < 0) isPossible = false;
                }
            }

            // System.out.println(mid + " " + daysElapsed);

            if(daysElapsed <= days && isPossible) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }

        return j;
    }
}