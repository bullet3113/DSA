// https://leetcode.com/problems/maximum-width-of-binary-tree

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
    public int widthOfBinaryTree(TreeNode root) {
        
        // BFS

        Deque<pair> dq = new LinkedList<>();

        int max = -1;
        dq.add(new pair(root, 0));

        while(!dq.isEmpty()) {
            
            // System.out.println(dq.peekFirst().node.val + " " + max + " " + dq.peekLast().idx + " " + dq.peekFirst().idx);

            int size = dq.size();
            int start = dq.peekFirst().idx;
            int end = -1;
            while(size > 0) {
                pair p = dq.remove();
            TreeNode currNode = p.node;
            int currIdx = p.idx;

            if(currNode.left != null) {
                dq.add(new pair(currNode.left, 2*currIdx + 1));
            }

            if(currNode.right != null) {
                dq.add(new pair(currNode.right, 2*currIdx + 2));
            }

            size--;
            if(size == 0) end = currIdx;
            }
            
            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}

class pair {
    TreeNode node;
    int idx;
    public pair(TreeNode node, int idx) {
        this.node = node;
        this.idx = idx;
    }
}