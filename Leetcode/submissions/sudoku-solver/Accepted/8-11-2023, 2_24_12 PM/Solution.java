// https://leetcode.com/problems/sudoku-solver

class Solution {
    char[][] matrix = new char[9][9];
    public void solveSudoku(char[][] board) {
        
        
        solver(board, 0, 0);

        for(int x = 0; x < 9; x++) {
            for(int y = 0; y < 9; y++) {
                board[x][y] = matrix[x][y];
            }
        }
    }

    void solver(char[][] board, int i, int j) {
        if(i == board.length) {
            for(int x = 0; x < 9; x++) {
                for(int y = 0; y < 9; y++) {
                    matrix[x][y] = board[x][y];
                }
            }
            return;
        }
        int ni = 0, nj = 0;

        if(j == board[0].length - 1) {
            ni = i+1;
            nj = 0;
        } else {
            ni = i;
            nj = j+1;
        }

        if(board[i][j] != '.') solver(board, ni, nj);
        else {
            for(int po = 1; po <= 9; po++) {
                if(isValid(board, i, j, (char)(po + 48))) {
                    board[i][j] = (char)(po + 48);
                    solver(board, ni, nj);
                    board[i][j] = '.';
                }
            }
        }
    }

    boolean isValid(char[][] board, int x, int y, char val) {
        // checking row
        for(int i = 0; i < board[0].length; i++) {
            if(board[x][i] == val) return false;
        }

        // checking column
        for(int i = 0; i < board.length; i++) {
            if(board[i][y] == val) return false;
        }

        // checking submatrix
        int smi = x/3 * 3;
        int smj = y/3 * 3;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i+smi][j+smj] == val) return false;
            }
        }

        return true;
    }
}