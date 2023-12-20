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
        bstIterator l = new bstIterator(root, true);
        bstIterator r = new bstIterator(root, false);

        int i = l.next();
        int j = r.next();

        while(i < j) {
            int sum = i + j;

            if(sum == k) return true;
            if(sum < k) i = l.next();
            else j = r.next();
        }

        return false;
    }
}

class bstIterator {
    TreeNode root;
    boolean isRev;

    Stack<TreeNode> st;
    public bstIterator(TreeNode root, boolean isRev) {
        this.root = root;
        this.isRev = isRev;
        st = new Stack<>();
        pushAll(this.root);
    }

    public int next() {
        TreeNode temp = st.pop();
        if(isRev) pushAll(temp.right);
        else pushAll(temp.left);
        return temp.val;
    }

    void pushAll(TreeNode root) {
        while(root != null) {
            st.push(root);
            if(isRev) root = root.left;
            else root = root.right;
        }
    }

}