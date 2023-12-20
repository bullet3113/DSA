// https://leetcode.com/problems/flood-fill

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int n = image.length;
        int m = image[0].length;

        int mat[][] = new int[n][m];

        helper(image, sr, sc, color, mat);

        return image;
    }

    void helper(int[][] image, int sr, int sc, int color, int[][] mat) {
        
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] == 0 || image[sr][sc] == color) {
            return;
        }
        
        // if(sr == image.length-1 && sc == image[0].length-1) {
        //     mat[sr][sc] = color;
        //     return;
        // }

        

        image[sr][sc] = color;

        helper(image, sr + 1, sc, color, mat);
        helper(image, sr - 1, sc, color, mat);
        helper(image, sr, sc + 1, color, mat);
        helper(image, sr, sc - 1, color, mat);
    }
}