// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        TreeNode root = null;
        if(inorder.length == 0) return root;

        int val = postorder[postorder.length-1];
        root = new TreeNode(val);
        // finding val in inorder array
        int pos = -1;
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == val) pos = i;
        }

        if(pos == -1) return null;

        root.right = buildTree(Arrays.copyOfRange(inorder, pos+1, inorder.length), Arrays.copyOfRange(postorder, pos, postorder.length-1));
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, pos), Arrays.copyOfRange(postorder, 0, pos));

        return root;
    }
}