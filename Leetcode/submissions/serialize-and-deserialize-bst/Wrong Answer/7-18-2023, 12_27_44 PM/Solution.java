// https://leetcode.com/problems/serialize-and-deserialize-bst

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "x,";


        return String.valueOf(root.val) + "," + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        // System.out.println(Arrays.toString(arr));
        int[] n = new int[1];
        TreeNode temp = helper(arr, n);
        // System.out.println(n[0]);
        return temp;
    }

    TreeNode helper(String[] arr, int n[]) {
        TreeNode node = null;
        if(n[0] < arr.length) {
            
            if(!arr[n[0]].startsWith("x")) 
                node = new TreeNode(Integer.parseInt(arr[n[0]].substring(0, 1)));

                n[0]++;
        if(node != null)
        {node.left = helper(arr, n);
        node.right = helper(arr, n);}

        } 
        
        

        // System.out.println(arr[n[0]]);
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;