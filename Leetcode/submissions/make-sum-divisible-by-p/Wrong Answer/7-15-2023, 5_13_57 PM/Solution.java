// https://leetcode.com/problems/make-sum-divisible-by-p

class Solution {
    public int minSubarray(int[] a, int p) {
    
		int n = a.length;
		long rem = 0l;
	  for(int i : a) rem = (rem + i) % p;
	  if(rem == 0) return 0;
	  // finding the smallest subarray whose sum is rem

	  int ans = Integer.MAX_VALUE;
	  int j = 0;
	  int sum = 0;
	  System.out.println(rem);
	  for(int i = 0; i < n; i++) {
		  sum = (sum + a[i]);
		  System.out.print(i + " " + sum + " ");
		  while(sum > rem && j <= i) {
			  sum -= a[j++];
		  }
		  if(sum == rem) {
			  ans = Math.min(ans, i - j + 1);
		  }
	  }

	  if(ans == Integer.MAX_VALUE || ans == n) return -1;
	  return ans;
    }
}