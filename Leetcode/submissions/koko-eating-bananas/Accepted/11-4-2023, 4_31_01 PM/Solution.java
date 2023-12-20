// https://leetcode.com/problems/koko-eating-bananas

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int n = piles.length;

        // finding max in array
        int j = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) j = Math.max(j, piles[i]);

        if(n == h) return j;

        // binary search
        int i = 1;

        while(i < j) {

            int mid = i + (j - i) / 2;

            int k = 0;
            for(int l = 0; l < n; l++) {
                k += ((int)Math.ceil(piles[l] * 1.0 / mid));
            }

            // System.out.println(mid + " " + k);
            if(k <= h) j = mid;
            else i = mid + 1;
        }

        return i;
    }
}