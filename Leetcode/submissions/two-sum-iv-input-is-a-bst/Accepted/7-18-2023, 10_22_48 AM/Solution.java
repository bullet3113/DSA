// https://leetcode.com/problems/two-sum-iv-input-is-a-bst

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
    public boolean findTarget(TreeNode root, int k) {
        bstIterator left = new bstIterator(root, true);
        bstIterator right = new bstIterator(root, false);       

        int i = left.next();
        int j = right.next();

        while(i < j) {
            int sum = i + j; 
            if(sum == k) return true;
            else if(sum < k) {
                i = left.next();
            } else {
                j = right.next();
            }
        }

        return false;
    }
}

class bstIterator {
    Stack<TreeNode> st;
    boolean isLeft;
    TreeNode node;

    public bstIterator(TreeNode node, boolean isLeft) {
        st = new Stack<>();
        this.node = node;
        this.isLeft = isLeft;
        pushAll(this.node);
    }

    int next() {
        TreeNode temp = st.pop();
        if(isLeft) pushAll(temp.right);
        else pushAll(temp.left);

        return temp.val;
    }

    void pushAll(TreeNode node) {
        while(node != null) {
            st.push(node);
            if(isLeft) node = node.left;
            else node = node.right;
        }       
    }
}