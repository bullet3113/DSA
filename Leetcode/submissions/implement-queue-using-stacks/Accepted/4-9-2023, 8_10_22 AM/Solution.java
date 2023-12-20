// https://leetcode.com/problems/implement-queue-using-stacks

class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;
    int size;
    int front;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        if(empty()) {
            s1.push(x);
            front = s1.peek();
        } else {
            s1.push(x);
        }
        
        size++;    
    }
    
    public int pop() {
        int temp = size;
        // storing the elements reversly in another stack
        while(temp > 0) {
            s2.push(s1.pop());
            temp--;
        }

        // popping out the first element
        int removed = s2.pop();
        size--;
        // assigning new peek element
        if(size > 0)
            front = s2.peek();
        else
            front = 0;
        // transfering elements back to original stack
        temp = size;
        while(temp > 0) {
            s1.push(s2.pop());
            temp--;
        }
        return removed;
    }
    
    public int peek() {
        return front;
    }
    
    public boolean empty() {
        return size == 0;
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