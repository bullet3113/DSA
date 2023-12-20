// https://leetcode.com/problems/binary-tree-postorder-traversal

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
         // using stack
        Stack<pair> st = new Stack<>();
        st.push(new pair(root, 1));

        List<Integer> ls = new ArrayList<>();
        if(root == null) return ls;
        while(!st.isEmpty()) {
            pair p = st.peek();
            if(p.state == 1) {
                p.state++;
                if(p.par.left != null)
                st.push(new pair(p.par.left, 1));
            } else if(p.state == 2) {
                p.state++;
                if(p.par.right != null)
                st.push(new pair(p.par.right, 1));
            } else {
                ls.add(p.par.val);
                st.pop();
            }
        }

        return ls;
    }
}

class pair {
    TreeNode par;
    int state;

    public pair(TreeNode par, int state) {
        this.par = par;
        this.state = state;
    }
}