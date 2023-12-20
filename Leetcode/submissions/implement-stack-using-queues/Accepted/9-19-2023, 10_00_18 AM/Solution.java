// https://leetcode.com/problems/implement-stack-using-queues

class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.add(x);
        while(!q2.isEmpty()) q1.add(q2.remove());
        while(!q1.isEmpty()) q2.add(q1.remove());
    }
    
    public int pop() {
        int popped = q2.remove();
        // while(!q2.isEmpty()) q1.add(q2.remove());
        return popped;
    }
    
    public int top() {
        return q2.peek();
    }
    
    public boolean empty() {
        return q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */