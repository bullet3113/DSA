// https://leetcode.com/problems/set-matrix-zeroes

class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<ArrayList<Integer>> map = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    map.add(temp);
                }
            }
        }

        for(ArrayList<Integer> list: map) {
            int x = list.get(0);
            int y = list.get(1);
            // System.out.println(x + " " + y);
            // traversing row first
            for(int i = 0; i < m; i++) matrix[x][i] = 0;

            // travering column
            for(int i = 0; i < n; i++) matrix[i][y] = 0;
        }
    }
}