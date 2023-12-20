// https://leetcode.com/problems/valid-triangle-number

class Solution {
    public int triangleNumber(int[] arr) {
        
        int ans = 0;
        int n = arr.length;
		for(int i = 0; i < n; i++) {
			int a = arr[i];
			for(int j = i + 1; j < n; j++) {
				int b = arr[j];
				for(int k = j + 1; k < n; k++) {
					int c = arr[k];
					if(a + b > c && b + c > a && a + c > b) ans++;
				}
			}
		}

		return ans;
    }
}