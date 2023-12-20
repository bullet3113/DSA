// https://leetcode.com/problems/grumpy-bookstore-owner

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;

        int[] temp = new int[n];

        for(int i = 0; i < n; i++) {
            if(customers[i] == 0) temp[i] = -1;
            else if(grumpy[i] == 1) temp[i] = 0;
            else temp[i] = customers[i];
        }

        int ans = 0;

        for(int i = 0; i < n; i++) {
            if(temp[i] == -1) continue;
            else ans += temp[i];
        }
        int globalMax = 0;
        for(int i = 0; i < n; i++) {
            if(temp[i] == 0) {
                int j = i;
                int limit = minutes;
                int curr = 0;
                while(j < n && j < i + minutes) {
                    if(temp[i] == 0) curr+= customers[i];
                    j++;
                }

                globalMax = Math.max(globalMax, curr);
            }
        }

        ans += globalMax;
        return ans;
    }
}


// [1,0,1,2,1,1,7,5]
// [0,1,0,1,0,1,0,1]
// [1,-1,1,0,1,0,7,0]