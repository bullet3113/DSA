// https://leetcode.com/problems/subtree-of-another-tree

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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(root == null) return false;

        boolean flag = isSameTree(root, subRoot);

        if(flag) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot) || flag;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if(p == null && q == null) return true;
        if(p == null && q != null) return false;
        else if(p != null && q == null) return false;

        if(p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);        
    }
}