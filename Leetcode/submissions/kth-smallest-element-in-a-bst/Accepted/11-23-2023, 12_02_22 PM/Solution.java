// https://leetcode.com/problems/kth-smallest-element-in-a-bst

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
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        
        if(root == null || count > k) return -1;

        int ans = kthSmallest(root.left, k);
        count++;
        // k--;
        if(k == count) return root.val;
        int ans2 = kthSmallest(root.right, k);

        return (ans != -1) ? ans : ans2;
    }
}