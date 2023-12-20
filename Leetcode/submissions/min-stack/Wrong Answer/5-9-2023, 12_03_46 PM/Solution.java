// https://leetcode.com/problems/min-stack

class MinStack {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    // int min;
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(s1.empty()) {
            s1.push(val);
            s2.push(val);
        } 
        s1.push(val);
        if(s1.peek() < s2.peek()) {
            s2.push(s1.peek());
        }
    }
    
    public void pop() {
        int temp = s1.pop();
        if(temp == s2.peek()) {
            s2.pop();
        }
    }
    
    public int top() {
        if(s1.empty())
            return 0;
        return s1.peek();
    }
    
    public int getMin() {
        if(s2.empty())
            return 0;
        return s2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */