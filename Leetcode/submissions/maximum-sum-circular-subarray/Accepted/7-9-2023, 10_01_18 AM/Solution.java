// https://leetcode.com/problems/maximum-sum-circular-subarray

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        // the most optimal approach
        // take min sum subarray
        // deduct from total sum
        // return the answer
        // have to handle one edge case 
        // if all values are -ve return max value of the array

        int total_sum = 0;
        int global_min = Integer.MAX_VALUE;
        int curr_min = 0;
        int global_max = Integer.MIN_VALUE;
        int curr_max = 0;
        int max_ele = Integer.MIN_VALUE; // if all values get -ve then return this
        boolean check = false; // to check if all the values are negative or not

        for(int i = 0; i < n; i++) {
            total_sum += nums[i];
            // change sign of all the elements in array
            // using this we can calculate the max sum using kadane algo
            
            if(nums[i] >= 0) check = true;
            max_ele = Math.max(max_ele, nums[i]); // edge case handled

            // applying kadane's algo
            // min sum
            curr_min += nums[i];
            global_min = Math.min(curr_min, global_min);
            curr_min = Math.min(0, curr_min);

            // max sum
            curr_max += nums[i];
            global_max = Math.max(curr_max, global_max);
            curr_max = Math.max(0, curr_max);
        }

        if(check) {
            return Math.max(global_max, total_sum - global_min);
        }

        // edge case all values were -ve
        return max_ele;
    }
}


// TLE: time limit exceeded
        /* // we have to start our index from each element
        int n = nums.length;
        int global_max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            int curr_max = 0;
            int si = i;
            int ei = n + i;

            while(si < ei) {
                curr_max += nums[si % n];
                
                global_max = Math.max(global_max, curr_max);
                curr_max = Math.max(curr_max, 0);
                si++;
            }
        }
        return global_max; */