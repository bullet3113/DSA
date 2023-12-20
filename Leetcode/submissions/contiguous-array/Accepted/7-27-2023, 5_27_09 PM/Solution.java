// https://leetcode.com/problems/contiguous-array

class Solution {
    public int findMaxLength(int[] nums) {
        
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] freq = new int[2];

        map.put(0, -1);
        int max = 0;

        for(int i = 0; i < n; i++) {
            freq[nums[i]]++;
            int key = freq[1] - freq[0];
            if(map.containsKey(key)) {
                max = Math.max(max, i - map.get(key));
            } else map.put(key, i);
        }

        return max;
    } 
}