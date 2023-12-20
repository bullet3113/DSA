// https://leetcode.com/problems/sum-of-subarray-minimums

class Solution {
    public int sumSubarrayMins(int[] arr) {
        // using the concept of previous smaller and next smaller
        int n = arr.length;
        System.out.println(n);
        int next_smaller[] = nsIndex(arr);
        int prev_smaller[] = psIndex(arr);

        int ans = 0;
        int mod = (int)1e9+7;
        for(int i = 0; i < n; i++) {
            ans += arr[i] * ((prev_smaller[i] + 1) * (next_smaller[i] + 1));
            ans %= 1e9+7;
        }

        return ans;
    }

    // getting a count of smaller elements not their indices

    int[] nsIndex(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        // stack.push(n-1);

        for(int i = n-1; i >= 0; i--) {
            if(!stack.empty() && arr[stack.peek()] < arr[i]) {
                ans[i] = stack.peek() - i - 1;
            } else {
                while(!stack.empty() && arr[stack.peek()] >= arr[i]) stack.pop();

                if(stack.empty()) ans[i] = n - i - 1;
                else ans[i] = stack.peek() - i - 1;
            }

            stack.push(i);
        }

        return ans;
    }


    int[] psIndex(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        // stack.push(0);

        for(int i = 0; i < n; i++) {
            if(!stack.empty() && arr[stack.peek()] < arr[i]) {
                ans[i] = i - stack.peek() - 1;
            } else {
                while(!stack.empty() && arr[stack.peek()] > arr[i]) stack.pop();

                if(stack.empty()) ans[i] = i;
                else ans[i] = i - stack.peek() - 1;
            }

            stack.push(i);
        }

        return ans;
    }    
}