// https://leetcode.com/problems/binary-tree-right-side-view

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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int s = q.size();
            
            if(q.peek() != null)
            list.add(q.peek().val);
            while(s > 0) {
                TreeNode dq = q.remove();
                
                if(dq != null)
                {if(dq.right != null) q.add(dq.right);
                if(dq.left != null) q.add(dq.left);}
                
                s--;
            }
        }
        return list;
    }
}