// https://leetcode.com/problems/make-sum-divisible-by-p

class Solution {
    public int minSubarray(int[] nums, int p) {
        
				long sum = 0;
        for(int num : nums) {
            sum = (sum + num) % p; // For large numbers using p as mod
        }
        
        if(sum % p == 0) {
            return 0;
        }
        
        int rem = ((int)sum % p + p) % p;      // The remainder to remove
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int len = n;
        long pSum = 0;
        
        map.put(0, -1);
        for(int i = 0; i < n; i ++) {
            
            pSum = (pSum + nums[i]) % p;    // For large numbers using p as mod
            // int currRem = ((int)pSum % p + p) % p;
            map.put((int)pSum, i);
            
            int remToSearch = (((int)pSum - (int)sum) % p + p) % p;
            if(map.containsKey(remToSearch)) {
                len = Math.min(len, i - map.get(remToSearch));
            }
            
        }
        
        if(len == n) {
            return -1;
        }
        return len;
    }
}