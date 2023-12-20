// https://leetcode.com/problems/symmetric-tree

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
    public boolean isSymmetric(TreeNode root) {
        if(root.left == null && root.right == null) return true;
        return helper(root.left, root.right);
    }

    boolean helper(TreeNode l, TreeNode r) {
        if(l == null && r == null) return true;
        else if(l == null && r != null) return false;
        else if(l != null && r == null) return false;
        // else if(l.left == null && r.right != null) return false;
        // else if(l.right == null && r.left != null) return false;

        if(l.val != r.val) return false;

        return helper(l.left, r.right) && helper(l.right, r.left);

    }
}