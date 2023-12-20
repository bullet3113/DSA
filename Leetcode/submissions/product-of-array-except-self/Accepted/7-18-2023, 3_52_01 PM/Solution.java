// https://leetcode.com/problems/product-of-array-except-self

class Solution {
    public int[] productExceptSelf(int[] nums) {
        long product = 1;
        long productWithoutZero = 1;
        int c = 0; // to count zeros in array
        // taking product of all the elements in the array
        for(int num: nums) {
            if(num == 0) c++;
            else productWithoutZero *= num;
            product *= num;
        }

        // adjusting the og array according to the requirement
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                if(c == 1) nums[i] = (int)productWithoutZero;    
                else nums[i] = 0;
            } else {
                nums[i] = (int)(product / nums[i]);
            }
        }
        return nums;
    }
}