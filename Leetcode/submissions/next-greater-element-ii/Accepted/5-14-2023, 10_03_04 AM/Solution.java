// https://leetcode.com/problems/next-greater-element-ii

class Solution {
    public int[] nextGreaterElements(int[] nums2) {
        if(nums2.length < 2) {
            nums2[0] = -1;
            return nums2;
        }

        // finding index of greatest element in an array
        int i = 0;
        int max = Integer.MIN_VALUE;
        int idx = 0;
        while(i < nums2.length) {
            if(nums2[i] > max) {
                max = nums2[i];
                idx = i;
            }
            i++;
        }
        Stack<Integer> stack = new Stack<>();
        
        int temp[] = new int[nums2.length];
        temp[idx] = -1;
        // int j = 0;
        stack.push(nums2[idx]);
        boolean check = false;
        // if(idx == nums2.length-1){
        // i = nums2.length-2;
        // check = true;
        // } else {
        // i = idx+1;
        // }
        i = idx-1;
        if(i < 0) 
           i = nums2.length + i;

        while(i != idx) {
           if(nums2[i] < stack.peek()) {
               temp[i] = stack.peek();
           } else {
               while(!stack.empty() && stack.peek() <= nums2[i]) {
                    stack.pop();    
               }
               if(stack.empty()) {
                       temp[i] = -1;
                   } else {
                       temp[i] = stack.peek();
                   }
           }
           stack.push(nums2[i]);
        //    if(check) {
        //        i--;
        //         i = Math.abs(i % nums2.length);
        //    }
        //    else {
               i--; 
               if(i < 0) {
                  i = nums2.length + i;
               }
            //    i = i % nums2.length;
        //    }
           
        }
        // i++;
        // if(!stack.empty() && nums2[i] < stack.peek()) {
        //        temp[i] = stack.peek();
        //    } else {
        //        while(!stack.empty() && stack.peek() <= nums2[i]) {
        //             stack.pop();    
        //        }
        //        if(stack.empty()) {
        //                temp[i] = -1;
        //            } else {
        //                temp[i] = stack.peek();
        //            }
        //    }

        // System.out.println(i);
        return temp;
    }
}