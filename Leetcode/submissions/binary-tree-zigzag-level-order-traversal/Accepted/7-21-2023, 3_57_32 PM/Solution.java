// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean isRight = false;

        while(!q.isEmpty()) {
            int size = q.size();

            List<Integer> temp = new ArrayList<>();
            while(size > 0) {
                TreeNode dq = q.remove();
                temp.add(dq.val);
                
                if(dq.left != null) q.add(dq.left);
                if(dq.right != null) q.add(dq.right);
                
                size--;
            }

            if(isRight) {
                isRight = false;
                Collections.reverse(temp);
            }
            else {isRight = true;}

            if(temp.size() > 0)
            list.add(new ArrayList<>(temp));
        }

        return list;
    }
}