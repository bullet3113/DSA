// https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced

class Solution {
    public int minSwaps(String s) {
        int swap = 0;
		int open = 0; 
        int n = s.length();
		for(int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if(ch == '[') open++;
			else {
				if(open > 0) open--;
				else {
					swap++;
					open++;
				}
			}
		}
		
		return swap;
    }
}