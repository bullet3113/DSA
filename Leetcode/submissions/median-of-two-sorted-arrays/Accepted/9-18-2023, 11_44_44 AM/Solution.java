// https://leetcode.com/problems/median-of-two-sorted-arrays

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;

        int idx = 0;
        int ele1 = 0;
        int ele2 = 0;

        int i = 0, j = 0;

        while(i < n1 && j < n2) {
            if(nums1[i] <= nums2[j]) {
                if(idx == n/2) ele2 = nums1[i];
                if(idx == n/2-1) ele1 = nums1[i];
                i++;
            } else {
                if(idx == n/2) ele2 = nums2[j];
                if(idx == n/2-1) ele1 = nums2[j];
                j++;
            }
            idx++;
        }

        while(i < n1) {
            if(idx == n/2) ele2 = nums1[i];
            if(idx == n/2-1) ele1 = nums1[i];
            i++;
            idx++;
        }

        while(j < n2) {
            if(idx == n/2) ele2 = nums2[j];
            if(idx == n/2-1) ele1 = nums2[j];
            j++;
            idx++;
        }

        return (n % 2 == 1) ? (double)ele2 : ((double)(ele2 + ele1)) / 2;
    }
}