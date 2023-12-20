// https://leetcode.com/problems/majority-element-ii

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer> list = new ArrayList<>();
        int n = nums.length;

        int freq = n / 3;

        int c1 = 0, e1 = 0, c2 = 0, e2 = 0;
        for(int i = 0; i < n; i++) {
            
            if(c1 == 0 && nums[i] != e2) {
                c1 = 1; e1 = nums[i];
            } else if(c2 == 0 && nums[i] != e1) {
                c2 = 1; e2 = nums[i];
            } else if(nums[i] == e1) c1++;
            else if(nums[i] == e2) c2++;
            else {
                c1--; c2--;
            }
        }

        c1 = 0; c2 = 0;
        for(int i = 0; i < n; i++) {
            if(e1 == nums[i]) c1++;
            else if(e2 == nums[i]) c2++;
        }

        if(c1 > freq) list.add(e1);
        if(c2 > freq) list.add(e2);

        return list;
    } 
}