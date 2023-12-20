// https://leetcode.com/problems/search-a-2d-matrix

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i < m; i++) {
            if(bSearch(matrix, i, target)) return true;
        }

        return false;
    }

    boolean bSearch(int[][] mat, int row, int t) {
        int i = 0, j = mat[0].length-1;

        while(i <= j) {
            int mid = i + (j - i) / 2;

            if(mat[row][mid] > t) j = mid - 1;
            else if(mat[row][mid] < t) i = mid + 1;
            else return true;
        }

        return false;
    }
}