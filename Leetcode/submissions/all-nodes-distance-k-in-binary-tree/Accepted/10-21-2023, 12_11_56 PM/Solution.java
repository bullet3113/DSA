// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // creating hashmap for storing parent pointers
        Map<TreeNode, TreeNode> map = new HashMap<>();
        dfs(root, null, map);
        
        List<Integer> ans = new ArrayList<>(); // answer storage
        dfs(target, k, ans, new HashSet<>(), map);
        // traveersing target node childs
        // going left
        // dfs(target.left, k, ans);
        // going right
        // dfs(target.right, k, ans);
        // going for parent of target node
        // TreeNode parent = map.get(target);
        // if(parent != null) {
        //    if (parent.left == target) parent = parent.right;
        //     else parent = parent.left;
        // }
        // while(parent != null) {
        //     // going left
        //     dfs(parent.left, k, ans);
        //     // going right
        //     dfs(parent.right, k, ans);

        //     // parent of parent
        //     parent = map.get(parent);
        // }

        // for(TreeNode temp: map.keySet()) {
        //     if(map.get(temp) != null)
        //     System.out.println(temp.val + " " + map.get(temp).val);
        // }

        return ans;
    }

    void dfs(TreeNode root, int k, List<Integer> ans, Set<TreeNode> set, Map<TreeNode, TreeNode> map) {
        if(root == null || k < 0 || set.contains(root)) return;

        set.add(root);
        if(k == 0) ans.add(root.val);
        dfs(map.get(root), k-1, ans, set, map);
        dfs(root.left, k-1, ans, set, map);
        dfs(root.right, k-1, ans, set, map);

        set.remove(root);
    }

    // dfs traversal
    void dfs(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> map) {
        if(root == null) return;

        map.put(root, parent);
        // going left
        dfs(root.left, root, map);
        // going right
        dfs(root.right, root, map);
    }
}