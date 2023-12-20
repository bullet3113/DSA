// https://leetcode.com/problems/xor-queries-of-a-subarray

class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        // sweep line
        int n = arr.length;
        int[] pref = new int[n];
        
        for(int i = 1; i < n; i++) {
            arr[i] ^= arr[i-1];
        }

        System.out.println(Arrays.toString(arr));

        int[] ans = new int[queries.length];

        for(int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            if(l == 0) ans[i] = arr[r];
            else ans[i] = arr[r] ^ arr[l-1];
        }

        return ans;
    }
}