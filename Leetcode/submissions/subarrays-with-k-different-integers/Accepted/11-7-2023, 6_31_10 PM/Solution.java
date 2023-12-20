// https://leetcode.com/problems/subarrays-with-k-different-integers

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        int n = nums.length;
        int[] kArray = answerArray(nums, n, k);
        int[] kMinusOneArray = answerArray(nums, n, k-1);

        int ans = 0;

        for(int i = 0; i < n; i++) {
            ans += Math.abs(kArray[i] - kMinusOneArray[i]);
        }

        return ans;
    }

    int[] answerArray(int[] nums, int n, int k) {
        
        int i = 0;
        int j = 0;
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        while(i < n) {
            
            int val = nums[i];

            map.put(val, map.getOrDefault(val, 0) + 1);

            while(map.size() > k && j < i) {
                int temp = nums[j];
                map.put(temp, map.get(temp) - 1);
                if(map.get(temp) == 0) map.remove(temp);
                j++;
            }

            if(map.size() <= k) {
                arr[i] = i - j + 1; 
            }

            i++;
        }

        return arr;
    }
}


// two hashmaps needed first one for k different integers
// second for k-1 different integers
// resultant will be sum of difference of their length