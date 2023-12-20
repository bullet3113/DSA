// https://leetcode.com/problems/largest-rectangle-in-histogram

class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++) {
            int temp = NSE(heights, i) - PSE(heights, i) - 1;
            if((temp * heights[i]) > max) {
                max = temp * heights[i];
            }
        }

        return max;
    }

    int NSE(int[] arr, int i) {
        // Stack<Integer> stack = new Stack<>();
        int temp = arr[i];
        i++;
        for(; i < arr.length; i++) {
            if(arr[i] < temp) {
                return i;
            }
        }

        return arr.length;
    }

    int PSE(int[] arr, int i) {
        // Stack<Integer> stack = new Stack<>();
        int temp = arr[i];
        i--;
        for(; i >= 0; i--) {
            if(arr[i] < temp) {
                return i;
            }
        }

        return -1;
    }
}