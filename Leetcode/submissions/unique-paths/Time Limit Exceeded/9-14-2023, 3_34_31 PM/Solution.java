// https://leetcode.com/problems/unique-paths

class Solution {

    public int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0) return 0;
        if(m == 1 && n == 1) return 1;

        int l = uniquePaths(m-1, n);
        int r = uniquePaths(m, n-1);

        return l + r;
    }
}