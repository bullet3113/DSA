// https://leetcode.com/problems/merge-sorted-array

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int j = 0; // for tracking nums2
        int i = 0; // for nums1

        while(i < m && j < n) {
            if(nums1[i] > nums2[j]) {
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                i++;
            } else i++;
        }

        while(i < m+n && j < n) {
            nums1[i++] = nums2[j++];
        }
    }
}