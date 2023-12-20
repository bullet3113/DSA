// https://leetcode.com/problems/count-good-nodes-in-binary-tree

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
    int max = Integer.MIN_VALUE;

    public int goodNodes(TreeNode root) {
        
        if(root == null) return 0;

        max = Math.max(max, root.val);
        int count = 0;
        if(root.val >= max) count = 1;

        return goodNodes(root.left) + goodNodes(root.right) + count;
    }
}