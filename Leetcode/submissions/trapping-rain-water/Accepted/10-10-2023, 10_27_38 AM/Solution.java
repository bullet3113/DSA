// https://leetcode.com/problems/trapping-rain-water

class Solution {
    public int trap(int[] arr) {

        int n = arr.length;
        // getting the next greater of all the elements
        int[] NGE = nextGreater(arr, n);

        // getting the previous greter of all the elments
        int[] PGE = prevGreater(arr, n);

        // building the answer
        int ans = 0;

        for(int i = 0; i < n; i++) {
            int elevation = Math.min(NGE[i], PGE[i]);
            int depth = elevation - arr[i];

            ans += depth;
        }

        return ans;
    }

     int[] nextGreater(int[] arr, int n) {

        int[] NGE = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.push(arr[n - 1]);
        NGE[n-1] = arr[n-1];

        for (int i = n - 2; i >= 0; i--) {
            int temp = arr[i];

            if (temp > stack.peek()) {
                stack.pop();
                stack.push(temp);
            }

            NGE[i] = stack.peek();
        }

        return NGE;
    }

     int[] prevGreater(int[] arr, int n) {

        int[] PGE = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        PGE[0] = arr[0];

        for (int i = 1; i < n; i++) {
            int temp = arr[i];

            if (temp > stack.peek()) {
                stack.pop();
                stack.push(temp);
            }

            PGE[i] = stack.peek();
        }

        return PGE;
    }
}