// https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int n = matrix.length;
		int m = matrix[0].length;
		int max = Integer.MIN_VALUE;
		// traversing by the columns

		int arr[] = new int[n];
		for(int z = 0; z < m; z++) {
			Arrays.fill(arr, 0);
			for(int i = z; i < m; i++) {
			for(int j = 0; j < n; j++) {
				arr[j] += matrix[j][i];
			}

			// applying kadane's algo
			int curr = 0;
			int global = Integer.MIN_VALUE;
			for(int j = 0; j < n; j++) {
				curr += arr[j];

				max = Math.max(Math.min(k, curr), max);
				curr = Math.max(curr, arr[j]);
				// max = Math.min(max, k);

				if(max == k) return k;
			}
		}
		}
		
		return max;
    }
}