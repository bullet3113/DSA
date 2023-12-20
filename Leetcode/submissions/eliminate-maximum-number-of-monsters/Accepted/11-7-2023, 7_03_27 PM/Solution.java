// https://leetcode.com/problems/eliminate-maximum-number-of-monsters

class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        
        int max = 1;
        int countMinute = 1;
        int n = dist.length;

        double[] time = new double[n];

        for(int i = 0; i < n; i++) {
            time[i] = (double)dist[i] / (double)speed[i];
        }

        Arrays.sort(time);
        // System.out.println(Arrays.toString(time));
        for(int i = 1; i < n; i++) {
            if(time[i] > countMinute) {
                max++;
                countMinute++;
            } else break;
        }

        return max;
    }
}

// n = monsters

// distance array

// d[i] = distance of ith monster from the city

// speed array

// s[i] = speed of ith monster approaching to the city km/minute

// weapon takes one minute to charge
// fully charge initially

// if weapon charge at same point monster reaches to city then it will lose

// return max monster to eliminate from entering city