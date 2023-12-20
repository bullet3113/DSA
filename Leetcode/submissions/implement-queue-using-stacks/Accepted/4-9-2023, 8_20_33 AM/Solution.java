// https://leetcode.com/problems/implement-queue-using-stacks

class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
            s1.push(x);
    }
    
    public int pop() {
        // storing the elements reversly in another stack
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        // popping out the first element
        int removed = s2.pop();
        // transfering elements back to original stack
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return removed;
    }
    
    public int peek() {
         while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        // popping out the first element
        int peeked = s2.peek();
        // transfering elements back to original stack
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return peeked;    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */