// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal

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

    int idx = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    TreeNode helper(int[] arr, int min, int max) {
        if(idx >= arr.length || arr[idx] < min || arr[idx] > max) return null;

        TreeNode node = new TreeNode(arr[idx++]);
        node.left = helper(arr, min, node.val);
        node.right = helper(arr, node.val, max);

        return node;
    }
}