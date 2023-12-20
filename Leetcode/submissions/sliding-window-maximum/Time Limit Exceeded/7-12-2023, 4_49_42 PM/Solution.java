// https://leetcode.com/problems/sliding-window-maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // firstyly we have to calculate the next greater index of the nums
        int n = nums.length;
        int[] nge = new int[n];
        NGE(nums, nge);

        // hitting the problem
        int[] ans = new int[n - k + 1];

        int i = 0, j = 0;

        while(j <= n - k) {
            int windowSize = j + k;
            if(i < j) i = j;
            while(nge[i] < windowSize) {
                i = nge[i];
                if(windowSize == n && i == n-1) break;
            }

            ans[j] = nums[i];
            j++;
        }
        
        return ans;
    }

    void NGE(int[] nums, int[] nge) {
        int n = nums.length;

        Stack<Integer> s = new Stack<>();
        s.push(n-1);
        nge[n-1] = n-1;

        for(int i = n-2; i >= 0; i--) {
    
            if(nums[i] < nums[s.peek()]) {
                nge[i] = s.peek();
            } else {
                while(!s.isEmpty() && nums[i] >= nums[s.peek()]) {
                    s.pop();
                }

                if(s.isEmpty()) {
                    nge[i] = i;
                } else {
                    nge[i] = s.peek();
                }
            }

            s.push(i);
        }
    }
}