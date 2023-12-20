// https://leetcode.com/problems/implement-trie-prefix-tree

class Node {
    Node[] child;
    boolean eow;

    public Node() {
        child = new Node[26];
        Arrays.fill(child, null);
        eow = false;
    }
}

class Trie {

    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if(curr.child[idx] == null) {
                curr.child[idx] = new Node();
            }

            if(i == word.length()-1) {
                curr.child[idx].eow = true;
            }

            curr = curr.child[idx];
        }
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if(curr.child[idx] == null) return false;
            if(i == word.length() - 1 && curr.child[idx].eow == false) {
                return false;
            }

            curr = curr.child[idx];
        }

        return true;
    }
    
    public boolean startsWith(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if(curr.child[idx] == null) return false;

            curr = curr.child[idx];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */