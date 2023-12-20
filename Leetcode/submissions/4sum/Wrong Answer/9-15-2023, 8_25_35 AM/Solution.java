// https://leetcode.com/problems/4sum

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();
        
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < n; j++) {
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int k = j+1;
                int l = n-1;

                while(k < l) {
                    long sum = nums[i] + nums[j] + nums[k] + nums[l];

                    if(sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        list.add(new ArrayList(temp));
                        k++; l--;
                        while(l >= k && nums[l] == nums[l+1]) l--;
                        while(k <= l && nums[k] == nums[k-1]) k++;
                        
                    } else if(sum > target) {
                        l--;
                    } else {
                        k++;
                    }
                } 
            }
        }

        return list;
    }
}