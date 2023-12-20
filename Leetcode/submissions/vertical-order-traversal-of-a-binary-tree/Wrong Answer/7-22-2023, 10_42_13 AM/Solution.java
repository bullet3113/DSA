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
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        helper(root, map, 0, 0);
        for(int key: map.keySet()) {
            List<Integer> temp = new ArrayList<>();
            for(int key2: map.get(key).keySet()) {
                temp.addAll(map.get(key).get(key2));
            }
            list.add(new ArrayList<>(temp));
        }

        return list;
    }

    void helper(TreeNode root, Map<Integer, Map<Integer, PriorityQueue<Integer>>> map, int idx, int lvl) {
        if(root == null) return;
        
        if(!map.containsKey(idx)) {
            map.put(idx, new TreeMap<>());        
        }

        if(!map.get(idx).containsKey(lvl)) {
            map.get(idx).put(lvl, new PriorityQueue<>());
        }
        map.get(idx).get(lvl).add(root.val);    
        
        helper(root.left, map, idx-1, lvl+1);
        helper(root.right, map, idx+1, lvl+1);
    }
}