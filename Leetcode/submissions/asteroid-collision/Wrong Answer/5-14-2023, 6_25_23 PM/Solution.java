// https://leetcode.com/problems/asteroid-collision

class Solution {
    public int[] asteroidCollision(int[] a) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < a.length; i++) {
            if(a[i] < 0) {
                if(!stack.empty() && stack.peek() == Math.abs(a[i]))
                    stack.pop();
                else if(!stack.empty() && stack.peek() > 0) {
                   while(!stack.empty() && stack.peek() > 0 && stack.peek() <= Math.abs(a[i])) {
                            stack.pop();
                        }

                        if(stack.empty() || stack.peek() < 0) {
                            stack.push(a[i]);
                        }
                    } 
                        
                    else {
                    stack.push(a[i]);
                }
            } else {
                stack.push(a[i]);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        while(!stack.empty()) 
            list.add(stack.pop());

        System.out.println(list);
        int ans[] = new int[list.size()];
        for(int i = list.size()-1; i >= 0; i--) {
            ans[ans.length-i-1] = list.get(i);
        }
        return ans;
    }
}