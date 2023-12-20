// https://leetcode.com/problems/asteroid-collision

class Solution {
    public int[] asteroidCollision(int[] a) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < a.length; i++) {
            if(a[i] < 0) {
                if(!stack.empty() && stack.peek() == Math.abs(a[i]))
                    stack.pop();
                else if(!stack.empty() && stack.peek() > 0) {
                   while(!stack.empty() && stack.peek() > 0 && stack.peek() < Math.abs(a[i])) {
                            stack.pop();
                        }
                        boolean check = true;
                        if(!stack.empty() && stack.peek() == Math.abs(a[i])){
                            stack.pop();
                            check = false;}
                        if(stack.empty() || stack.peek() < 0) {
                            if(check)
                            stack.push(a[i]);
                        }
                    } 
                        
                //     else {
                //     stack.push(a[i]);
                // }
            } else {
                stack.push(a[i]);
            }
        }

        int ans[] = new int[stack.size()];
        for(int i = stack.size()-1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}