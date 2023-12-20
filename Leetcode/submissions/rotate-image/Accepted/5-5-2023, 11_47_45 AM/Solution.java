// https://leetcode.com/problems/rotate-image

class Solution {
    public void rotate(int[][] matrix) {
        // swapping rows
        rowSwap(matrix, 0, matrix.length-1);
        transpose(matrix);
    }

    void transpose(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    void rowSwap(int[][] mat, int i, int n) {
        if(i >= n) {
            return;
        }

        swap(mat, i, n);
        rowSwap(mat, i+1, n-1);
    }

    void swap(int[][] mat, int i, int i2) {
            for(int j = 0; j < mat.length; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i2][j];
                mat[i2][j] = temp;
            }
    }
}