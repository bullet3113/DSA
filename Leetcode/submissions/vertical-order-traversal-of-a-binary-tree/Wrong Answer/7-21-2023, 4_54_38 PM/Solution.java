// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree

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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        helper(root, map, 0);
        for(int key: map.keySet()) {
            // Collections.sort(map.get(key));
            ArrayList<Integer> temp = map.get(key);
            if(temp.size() == 3) {
                int l = temp.get(2);
                int m = temp.get(1);
                if(m > l) {
                    temp.set(1, l);
                    temp.set(2, m);
                }
            }
            list.add(map.get(key));
            }

        return list;
    }

    void helper(TreeNode root, Map<Integer, ArrayList<Integer>> map, int idx) {
        if(root == null) return;
        
        if(!map.containsKey(idx)) 
            map.put(idx, new ArrayList<>());
            map.get(idx).add(root.val);    
        //  else {
            
        // }
        
        helper(root.left, map, idx-1);
        helper(root.right, map, idx+1);
    }
}