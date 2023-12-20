// https://leetcode.com/problems/diameter-of-binary-tree

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
    public int diameterOfBinaryTree(TreeNode root) {
        
        if(root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left + right, Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }

    int height(TreeNode root) {
        if(root == null) return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }
}