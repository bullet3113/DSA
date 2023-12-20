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
        Map<Integer, TreeNode> map = new HashMap<>();
		helper(root, 0, map);
		int n = map.size();
        List<Integer> list = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			list.add(map.get(i).val);
		}

        return list;
    }

    void helper(TreeNode root, int level, Map<Integer, TreeNode> map) {
		if(root == null)
			return;

		if(!map.containsKey(level)) {
			map.put(level, root);
		}
        
        helper(root.right, level+1, map);
		helper(root.left, level+1, map);
		
	}
}