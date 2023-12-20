// https://leetcode.com/problems/gas-station

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int n = gas.length;
        int sum = 0;
        int idx = -1;

        boolean check = true;
        for(int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];

            if(sum < 0) {
                sum = 0;
                check = true;
                idx = -1;
            } else if(check) {
                idx = i;
                check = false;
            }
        }

        for(int i = 0; i < idx; i++) {
            sum += gas[i] - cost[i];
            if(sum < 0) return -1;
        } 

        if(sum >= 0) return idx;

        return -1;
    }
}