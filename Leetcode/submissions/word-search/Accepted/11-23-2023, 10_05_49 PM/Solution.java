// https://leetcode.com/problems/word-search

class Solution {
    public boolean exist(char[][] board, String word) {
        
        int n = word.length();
        int row = board.length;
        int col = board[0].length;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                char ch = word.charAt(0);
                if(ch == board[i][j] && helper(board, word, "", n, row, col, i, j, 0, new boolean[row][col])) return true; 
            }
        }
        return false;
    }

    boolean helper(char[][] board, String word, String p, int n, int row, int col, int i, int j, int index, boolean[][] vis) {
        
        if(index == n) return true;
        if(i >= row || j >= col || i < 0 || j < 0 || vis[i][j] || word.charAt(index) != board[i][j]) return false;
        // System.out.println(p);
        

        vis[i][j] = true;

        boolean up = helper(board, word, p + board[i][j], n, row, col, i-1, j, index+1, vis);
        boolean down = helper(board, word, p + board[i][j], n, row, col, i+1, j, index+1, vis);
        boolean left = helper(board, word, p + board[i][j], n, row, col, i, j-1, index+1, vis);
        boolean right = helper(board, word, p + board[i][j], n, row, col, i, j+1, index+1, vis);

        vis[i][j] = false;

        return up || down || left || right;
    }
}