// https://leetcode.com/problems/single-number-ii

class Solution {
    public int singleNumber(int[] arr) {
        int tn = Integer.MAX_VALUE; // all bits set to 1
		int tnp1 = 0, tnp2 = 0; // all bits set to 0

		for(int i = 0; i < arr.length; i++) {
			int cwtn = arr[i] & tn;
			int cwtnp1 = arr[i] & tnp1;
			int cwtnp2 = arr[i] & tnp2;

			tn = (tn & (~cwtn));
			tnp1 = (tnp1 | cwtn);

			tnp1 = (tnp1 & (~cwtnp1));
			tnp2 = (tnp2 | cwtnp1);

			tnp2 = (tnp2 & (~cwtnp2));
			tn = (tn | cwtnp2);
		}

		return tnp1;
    }
}