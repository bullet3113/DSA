// https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        // loop till n-k
        // use hashmap to monitor occurences in each subarray
        long ans = 0l;
        int n = nums.length;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < k; i++) {
            sum += nums[i];
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1); 
            } else {
                map.put(nums[i], 1);
            }
        }

        boolean check = true;
        for(Integer m: map.keySet()) {
            if(map.get(m) > 1) {
                check = false;
                break;
            }
        }
        if(check)
        ans = sum;

        for(int i = 0; i < n-k; i++) {
            sum -= nums[i];
            sum += nums[i+k];
            // reduce older one
            map.put(nums[i], map.get(nums[i]) - 1); 
            // add new one 
            if(map.containsKey(nums[i+k])) {
                map.put(nums[i+k], map.get(nums[i+k]) + 1); 
            } else {
                map.put(nums[i+k], 1);
            }

            check = true;
            for(Integer m: map.keySet()) {
                if(map.get(m) > 1) {
                    check = false;
                    break;
                }
            }

            if(check) {
                if(sum > ans) {
                    ans = sum;
                }
            }
        }

        return ans;
    }
}