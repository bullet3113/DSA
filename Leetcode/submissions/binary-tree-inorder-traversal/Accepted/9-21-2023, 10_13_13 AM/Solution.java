// https://leetcode.com/problems/binary-tree-inorder-traversal

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
    public List<Integer> inorderTraversal(TreeNode root) {
        // Morris Traversal
        List<Integer> list = new ArrayList<>();
        
        TreeNode curr = root;

        while(curr != null) {
            if(curr.left == null) {
                list.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode temp = curr.left;
                // going rightmost
                while(temp.right != null && temp.right != curr) {
                    temp = temp.right;
                }
                
                if(temp.right == curr) {
                    curr = temp.right;
                    curr.left = null;
                } else {
                    temp.right = curr;
                curr = curr.left;
                }
                
            }
        }

        return list;
    }
}