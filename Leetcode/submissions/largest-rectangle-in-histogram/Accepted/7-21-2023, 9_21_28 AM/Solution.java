// https://leetcode.com/problems/largest-rectangle-in-histogram

class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = Integer.MIN_VALUE;
        int[] nse = NSE(heights);
        int[] pse = PSE(heights);

        for(int i = 0; i < heights.length; i++) {
            int temp = nse[i] - pse[i] - 1;
            // if((temp * heights[i]) > max) {
            //     max = temp * heights[i];
            // }

            max = Math.max(max, (temp * heights[i]));
        }

        return max;
    }

    int[] NSE(int[] arr) {
        int n = arr.length;

        int nse[] = new int[n];
        nse[n-1] = n;
        Stack<Integer> stack = new Stack<>();
        stack.push(n-1);
        
        for(int i = n-2; i >= 0; i--) {
            int temp = arr[i];

            while(!stack.isEmpty() && arr[stack.peek()] >= temp) stack.pop();

            if(stack.empty()) nse[i] = n;
            else nse[i] = stack.peek();

            stack.push(i);
        }

        return nse;
    }


    int[] PSE(int[] arr) {
        int n = arr.length;

        int pse[] = new int[n];
        pse[0] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for(int i = 1; i < n; i++) {
            int temp = arr[i];

            while(!stack.isEmpty() && arr[stack.peek()] >= temp) stack.pop();

            if(stack.empty()) pse[i] = -1;
            else pse[i] = stack.peek();

            stack.push(i);
        }

        return pse;
    }

    // int PSE(int[] arr, int i) {
    //     // Stack<Integer> stack = new Stack<>();
    //     int temp = arr[i];
    //     i--;
    //     for(; i >= 0; i--) {
    //         if(arr[i] < temp) {
    //             return i;
    //         }
    //     }

    //     return -1;
    // }
}