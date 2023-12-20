// https://leetcode.com/problems/boats-to-save-people

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);
        int ans = 0;
        int i = 0, j = n-1;

        while(i <= j) {
            int sum = people[i] + people[j];
            if(sum == limit) {
                i++; j--; ans++;
            } else if(sum < limit) {
                i++; j--; ans++;
            } else if(sum > limit) {
                j--; ans++;
            }
        }
        return ans;
    }
}