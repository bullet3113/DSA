// https://leetcode.com/problems/range-sum-query-immutable

class NumArray {

    int n;
    int pref[];
    public NumArray(int[] nums) {
        n = nums.length;
        pref = new int[n];
        int sum = 0;
        // calculating prefix sum
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            pref[i] = sum;
        }
    }
    
    public int sumRange(int left, int right) {
        if(left == 0) return pref[right];

        return pref[right] - pref[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */