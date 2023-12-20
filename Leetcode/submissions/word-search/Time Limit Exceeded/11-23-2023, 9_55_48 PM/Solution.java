// https://leetcode.com/problems/word-search

class Solution {
    public boolean exist(char[][] board, String word) {
        
        int n = word.length();
        int row = board.length;
        int col = board[0].length;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(helper(board, word, "", n, row, col, i, j, new boolean[row][col])) return true; 
            }
        }
        return false;
    }

    boolean helper(char[][] board, String word, String p, int n, int row, int col, int i, int j,boolean[][] vis) {
        
        if(word.equals(p)) return true;
        if(i >= row || j >= col || i < 0 || j < 0 || vis[i][j] || p.length() > n) return false;
        // System.out.println(p);
        

        vis[i][j] = true;

        boolean up = helper(board, word, p + board[i][j], n, row, col, i-1, j, vis);
        boolean down = helper(board, word, p + board[i][j], n, row, col, i+1, j, vis);
        boolean left = helper(board, word, p + board[i][j], n, row, col, i, j-1, vis);
        boolean right = helper(board, word, p + board[i][j], n, row, col, i, j+1, vis);

        vis[i][j] = false;

        return up || down || left || right;
    }
}