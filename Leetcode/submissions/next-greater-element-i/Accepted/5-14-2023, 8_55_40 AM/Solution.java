// https://leetcode.com/problems/next-greater-element-i

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        // getting all the next greater of num2 first

        Stack<Integer> stack = new Stack<>();
        stack.push(nums2[nums2.length-1]);
        int temp[] = new int[nums2.length];
        temp[nums2.length-1] = -1;
        int j = 0;
        for(int i = nums2.length-2; i >= 0; i--) {
           if(nums2[i] < stack.peek()) {
               temp[i] = stack.peek();
           } else {
               while(!stack.empty() && stack.peek() < nums2[i]) {
                    stack.pop();    
               }
               if(stack.empty()) {
                       temp[i] = -1;
                   } else {
                       temp[i] = stack.peek();
                   }
           }stack.push(nums2[i]);
           if(j < nums1.length && nums1[j] == nums2[i]) {
               nums1[j] = temp[i];
               j++;
           }
           
        }

        // traversing nums1 array to check for next greater element
        while(j < nums1.length) {
            for(int i = 0; i < nums2.length; i++) {
                if(nums1[j] == nums2[i]) {
                    nums1[j] = temp[i];
                    break;
                }
            }
            j++;
        }

        System.out.println(Arrays.toString(temp));
        return nums1;
    }
}