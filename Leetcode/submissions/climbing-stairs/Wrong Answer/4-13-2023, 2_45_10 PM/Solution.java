// https://leetcode.com/problems/climbing-stairs

class Solution {
    public int climbStairs(int n) {
        if(n <= 1) {
            return n;
        }
        
        // if(n == 1)/
        
        return climbStairs(n-1) + climbStairs(n-2);
    }
}