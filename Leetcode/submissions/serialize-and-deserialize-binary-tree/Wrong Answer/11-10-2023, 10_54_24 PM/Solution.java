// https://leetcode.com/problems/serialize-and-deserialize-binary-tree

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
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        String encoded = "";

        while(!q.isEmpty()) {
            TreeNode dq = q.remove();

            if(dq != null) {
                encoded += String.valueOf(dq.val);
                q.add(dq.left);
                q.add(dq.right);
            } else {
                encoded += "n";
            }
        }

        return encoded;

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        // System.out.println(data);
        if(data.charAt(0) == 'n') return null;
        // constructing tree level order wise
        char ch = data.charAt(0);
        int v = -1;
        if(ch == '-') {
            v = -1 * (data.charAt(1) - '0');
            data = data.substring(2);
        } else {
            v = ch - '0';
            data = data.substring(1);
        }
        TreeNode root = new TreeNode(v);
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                TreeNode curr = q.remove();
                char c1 = 'n';
                char c2 = 'n';

                int v1 = -1;
                int v2 = -1;
                if(data.length() >= 2) {
                    c1 = data.charAt(0);
                    if(c1 == '-') {
                        v1 = -1 * (data.charAt(1) - '0');
                        data = data.substring(2);
                    } else {
                        v1 = c1 - '0';
                        data = data.substring(1);
                    }
                    c2 = data.charAt(0);
                    if(c2 == '-') {
                        v2 = -1 * (data.charAt(1) - '0');
                        data = data.substring(2);
                    } else {
                        v2 = c2 - '0';
                        data = data.substring(1);
                    }
                } else if(data.length() == 1) {
                    c1 = data.charAt(0);
                    data = data.substring(1);
                    v1 = c1 - '0';
                }

                if(c1 != 'n') {
                    curr.left = new TreeNode(v1);
                    q.add(curr.left);
                }
                if(c2 != 'n') {
                    curr.right = new TreeNode(v2);
                    q.add(curr.right);    
                }

                size--;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));