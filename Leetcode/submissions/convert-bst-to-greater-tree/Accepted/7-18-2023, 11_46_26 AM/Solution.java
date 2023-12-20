// https://leetcode.com/problems/convert-bst-to-greater-tree

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
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return root;

        root.right = convertBST(root.right);
        sum += root.val;
        root.val = sum;
        root.left = convertBST(root.left);

        return root;
    }
}