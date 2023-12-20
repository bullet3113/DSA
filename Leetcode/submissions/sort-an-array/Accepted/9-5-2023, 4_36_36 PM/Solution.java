// https://leetcode.com/problems/sort-an-array

class Solution {
    public int[] sortArray(int[] nums) {
        
        // using the merge sort algorithm
        if(nums.length == 1) return nums;

        int mid = nums.length/2;
        int[] left = sortArray(Arrays.copyOfRange(nums, 0, mid));
        int[] right = sortArray(Arrays.copyOfRange(nums, mid, nums.length));

        return merge(left, right);
    }

    int[] merge(int[] L, int[] R) {
        int n1 = L.length;
        int n2 = R.length;

        int[] nums = new int[n1 + n2];

        int i = 0, j = 0;
        int k = 0;

        while(i < n1 && j < n2) {
            if(L[i] < R[j]) {
                nums[k] = L[i];
                i++;
            } else {
                nums[k] = R[j];
                j++;
            }

            k++;
        }

        while(i < n1) {
            nums[k] = L[i];
            i++; 
            k++;
        }

        while(j < n2) {
            nums[k] = R[j];
            j++;
            k++;
        }

        return nums;
    }
}