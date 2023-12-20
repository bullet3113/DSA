// https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum

class Solution {
    public int minStartValue(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];

        // calculate prefix sum
        int sum = 0;
        boolean check = false;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            pre[i] = sum;
            if(sum <= 0) check = true; // if found any 0 or negative sum then only check for ans
        }

        int x = Math.abs(pre[0]) + 1;
        while(check) {
            for(int i = 0; i < n; i++) {
                if(pre[i] + x <= 0) {
                    x++;
                    i = -1;
                } 
            }

            return x;
        }
        
        return 1;
    }
}