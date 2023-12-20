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

        while(i <= n - k) {
            j = i;
            while(nge[j]<i+k){
                j = nge[j];
            }
            ans[i] = nums[j];
            i++;
        }
        
        return ans;
    }

    void NGE(int[] nums, int[] nge) {
        int n = nums.length;
        nge[nums.length-1]=nums.length;
        Stack<Integer> st=new Stack<>();
        st.push(nums.length-1);
        for(int i=nums.length-2;i>=0;i--){
            while(st.size()>0 && nums[i]>=nums[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                nge[i]=nums.length;
            }else{
                nge[i]=st.peek();
            }
            st.push(i);
        }
    }
}