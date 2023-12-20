// https://leetcode.com/problems/container-with-most-water

class Solution {
    public int maxArea(int[] height) {
        
        int n = height.length;
        int i = 0;
        int j = n - 1;

        int max = Integer.MIN_VALUE;

        while(i < j) {

            int area = (j - i) * Math.min(height[i], height[j]);
            max = Math.max(max, area);

            if(height[i] <= height[j]) i++;
            else j--;
        }

        return max;
    }
}