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
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean isRight = true;

        while(!q.isEmpty()) {
            int size = q.size();

            List<Integer> temp = new ArrayList<>();
            while(size > 0) {
                TreeNode dq = q.remove();
                if(dq != null)
                temp.add(dq.val);
                
                if(dq != null) {
                    if(isRight) {
                        if(dq.right != null) q.add(dq.right);
                        if(dq.left != null) q.add(dq.left);
                  } else {
                        if(dq.left != null) q.add(dq.left);
                        if(dq.right != null) q.add(dq.right);
                 }
                }

                size--;
            }

            if(temp.size() > 0)
            list.add(new ArrayList<>(temp));
            if(isRight) isRight = false;
            else isRight = true;
        }

        return list;
    }
}