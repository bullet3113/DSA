// https://leetcode.com/problems/recover-binary-search-tree

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
    
    TreeNode first = null;
    TreeNode mid = null;
    TreeNode last = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        
        // inorder traversal
        helper(root);

        if(first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else if(first != null && mid != null) {
            int temp = first.val;
            first.val = mid.val;
            mid.val = temp;
        }
    }

    void helper(TreeNode root) {
        if(root == null) return;

        helper(root.left);

        if(prev != null && root.val < prev.val) {
            if(first == null) {
                first = prev;
                mid = root;
            } else {
                last = root;
            }
        }

        prev = root;

        helper(root.right);
    }
}