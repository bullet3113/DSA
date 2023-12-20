// https://leetcode.com/problems/car-pooling

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        int[] kms = new int[1001];

        for(int trip[]: trips) {
            kms[trip[1]] += trip[0]; // pickup
            kms[trip[2]] -= trip[0]; // drop
        }

        int currentCapacity = 0;

        for(int passengers: kms) {
            currentCapacity += passengers;

            if(currentCapacity > capacity) return false;
        }

        return true;
    }
}