// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal

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
    public TreeNode buildTree(int[] pre, int[] in) {
        int n = pre.length;
        return helper(in, pre, new int[]{0}, n);
    }

     TreeNode helper(int[] in, int[] pre, int[] i, int n) {
		if(i[0] == n) return null;

		int ele = pre[i[0]];
		int idx = -1;
		// finding the ele index in inorder array
		for(int j = 0; j < in.length; j++) {
			if(in[j] == ele) {
				idx = j;
				break;
			}
		}
		if(idx == -1) return null;
		i[0]++;
		TreeNode node = new TreeNode(ele);

		node.left = helper(Arrays.copyOfRange(in, 0, idx), pre, i, n);
		node.right = helper(Arrays.copyOfRange(in, idx+1, n), pre, i, n);

		return node;
	}
}