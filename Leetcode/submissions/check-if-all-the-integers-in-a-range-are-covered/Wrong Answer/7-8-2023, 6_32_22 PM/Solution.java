// https://leetcode.com/problems/check-if-all-the-integers-in-a-range-are-covered

class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        boolean check_l = false;
        boolean check_r = false;

        int n = ranges.length;

        for(int i = 0; i < n; i++) {
            if(ranges[i][0] == left || ranges[i][1] == left) check_l = true;
            if(ranges[i][0] == right || ranges[i][1] == right) check_r = true;
        }

        return check_l && check_r;
    }
}