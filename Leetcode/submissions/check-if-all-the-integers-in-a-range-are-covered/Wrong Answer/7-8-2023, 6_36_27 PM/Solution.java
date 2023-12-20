// https://leetcode.com/problems/check-if-all-the-integers-in-a-range-are-covered

class Solution {
    public boolean isCovered(int[][] ranges, int a, int b) {
        boolean check_l = false;
        boolean check_r = false;

        int n = ranges.length;

        for(int i = 0; i < n; i++) {
            int l = ranges[i][0];
			int r = ranges[i][1];

			if(l <= a) {check_l = true;}
			if(r >= b) {check_r = true;}
            // if(ranges[i][0] >= left || ranges[i][1] <= left) check_l = true;
            // if(ranges[i][0] >= right || ranges[i][1] <= right) check_r = true;
        }

        return check_l && check_r;
    }
}