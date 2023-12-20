// https://leetcode.com/problems/surrounded-regions

class Solution {
    public void solve(char[][] board) {
        
        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if((i == 0 || i == n-1 || j == 0 || j == m-1) && !vis[i][j] && board[i][j] == 'O') {
                    helper(board, i, j, vis);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if((i != 0 || i != n-1 || j != 0 || j != m-1) && !vis[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    void helper(char[][] board, int i, int j, boolean[][] vis) {

        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || vis[i][j] || board[i][j] == 'X') return;

        vis[i][j] =  true;
        helper(board, i+1, j, vis);
        helper(board, i-1, j, vis);
        helper(board, i, j+1, vis);
        helper(board, i, j-1, vis);
    }
}