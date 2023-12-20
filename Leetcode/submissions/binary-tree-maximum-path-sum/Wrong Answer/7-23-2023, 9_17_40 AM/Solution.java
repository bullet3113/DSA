// https://leetcode.com/problems/binary-tree-maximum-path-sum

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
    public int maxPathSum(TreeNode node) {
        int max[] = new int[1];
		helper(node, max);
		return max[0];
    }

    int helper(TreeNode node, int[] max) {
		if(node == null)
			return 0;

		int lSum = Math.max(0, helper(node.left, max));
		int rSum = Math.max(0, helper(node.right, max));
		max[0] = Math.max(max[0], node.val + lSum + rSum);
		return node.val + Math.max(lSum, rSum);
	}
}