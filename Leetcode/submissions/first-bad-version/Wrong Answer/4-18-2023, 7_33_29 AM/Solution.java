// https://leetcode.com/problems/first-bad-version

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int s = 0;
        int e = n;
        while(s < e) {
            int mid = s + (e - s) / 2;
            if(isBadVersion(mid)) {
                if(!isBadVersion(mid-1)) {
                    return mid;
                } else {
                    e = mid - 1;
                }
            } else {
                s = mid + 1;
            }
        }
        return 1;
    }
}