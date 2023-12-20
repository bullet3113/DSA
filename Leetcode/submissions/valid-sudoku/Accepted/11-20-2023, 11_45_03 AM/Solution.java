// https://leetcode.com/problems/valid-sudoku

class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                char ch = board[i][j];

                if(ch == '.') continue;

                if(!checkRowCol(board, i, j)) return false;
                if(!checkSubMatrix(board, i, j)) return false;
            }
        }

        return true;
    }

    boolean checkRowCol(char[][] board, int row, int col) {

        // checking row
        for(int i = 0; i < board.length; i++) {
            char ch = board[i][col];
            if(i == row) continue;
            if(ch == board[row][col]) return false;
        }

        // checking col
        for(int i = 0; i < board[0].length; i++) {
            char ch = board[row][i];
            if(i == col) continue;
            if(ch == board[row][col]) return false;
        }

        return true;
    }

    boolean checkSubMatrix(char[][] board, int row, int col) {

        int n = row - (row % 3);
        int m = col - (col % 3);

        for(int i = n; i < n+3; i++) {
            for(int j = m; j < m+3; j++) {

                char ch = board[i][j];
                if(i == row && col == j) continue;

                if(ch == board[row][col]) return false;
            }
        }

        return true;
    }
}