// https://leetcode.com/problems/find-the-highest-altitude

class Solution {
    public int largestAltitude(int[] gain) {
        // simply calculate the prefix sum
        // find the highest value in the prefix sum array

        int n = gain.length;
        int max = Math.max(0, gain[0]);

        for(int i = 1; i < n; i++) {
            gain[i] += gain[i - 1];
            max = Math.max(gain[i], max);
        }
        return max;
    }
}