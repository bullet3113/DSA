// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets

class Solution {
    public int minDays(int[] arr, int m, int k) {
        
        int n = arr.length;

        // finding the max day in array
        int j = -1;
        for(int i = 0; i < n; i++) j = Math.max(j, arr[i]);

        int i = 0;
        boolean isAnyWayPossible = false;

        while(i <= j) {

            int mid = i + (j - i) / 2;

            int bouquetMadeTillNow = 0;
            int adjacentCount = 0;
            for(int l = 0; l < n; l++) {
                if(arr[l] <= mid) adjacentCount++;
                else adjacentCount = 0;
                if(adjacentCount == k) {
                    bouquetMadeTillNow++;
                    adjacentCount = 0;
                }
            }

            // System.out.println(mid + " " + bouquetMadeTillNow);
            if(bouquetMadeTillNow >= m) {j = mid-1; isAnyWayPossible = true;}
            else i = mid + 1;
        }

        // System.out.println(i);
        // if(isAnyWayPossible)
        

        int bouquetMadeTillNow = 0;
            int adjacentCount = 0;
            for(int l = 0; l < n; l++) {
                if(arr[l] <= i) adjacentCount++;
                else adjacentCount = 0;
                if(adjacentCount == k) {
                    bouquetMadeTillNow++;
                    adjacentCount = 0;
            }
        }

        if(bouquetMadeTillNow >= m) return i;
        return -1;
    }
}