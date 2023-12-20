// https://leetcode.com/problems/populating-next-right-pointers-in-each-node

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        // getting the level order traversal first
        Node curr = root;
        Queue<Node> q = new LinkedList<>();

        q.add(curr);

        while(!q.isEmpty()) {
            int size = q.size();

            while(size > 0) {
                Node dq = q.remove();

                if(dq != null) {
                    if(size == 1) dq.next = null;
                else {
                    dq.next = q.peek();
                }

                if(dq.left != null) q.add(dq.left);
                if(dq.right != null) q.add(dq.right);

                // dq.right = null;
                }

                size--;
            }
        }

        return root;
    }
}