// https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
          int n = matrix.length;
        int m = matrix[0].length;
        int max = Integer.MIN_VALUE;
 
        for (int left = 0; left < m; left++) {
            int[] sums = new int[n];
            for (int right = left; right < m; right++) {
                for (int i = 0; i < n; i++) {
                    sums[i] += matrix[i][right];
                }
 
                int currMax = Integer.MIN_VALUE;
                int currSum = 0;
 
                for (int i = 0; i < n; i++) {
                    currSum = Math.max(currSum + sums[i], sums[i]);
                    currMax = Math.max(currMax, currSum);
                }
 
                if (currMax <= k) {
                    max = Math.max(max, currMax);
                    continue;
                }
 
                for (int i = 0; i < n; i++) {
                    int sum = 0;
                    for (int j = i; j < n; j++) {
                        sum += sums[j];
                        if (sum <= k) {
                            max = Math.max(max, sum);
                        }
                    }
                }
            }
        }
 
        return max;
    }
}