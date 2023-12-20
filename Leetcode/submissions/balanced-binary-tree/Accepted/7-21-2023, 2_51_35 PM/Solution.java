// https://leetcode.com/problems/balanced-binary-tree

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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int l = helper(root.left);
        int r = helper(root.right);

        return Math.abs(l - r) <= 1 && isBalanced(root.left) && isBalanced(root.right);

    }

    int helper(TreeNode root) {
        if(root == null) return 0;

        return 1 + Math.max(helper(root.left), helper(root.right));
    }
}