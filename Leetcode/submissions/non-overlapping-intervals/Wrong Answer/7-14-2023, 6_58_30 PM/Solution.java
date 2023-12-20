// https://leetcode.com/problems/non-overlapping-intervals

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        // sorting the intervals array according to starting points
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        int c = 0;
        int psp = -1; // parent starting pointer
        int pep = -1; // parent ending pointer

        for(int[] a: intervals) {
            // System.out.println(Arrays.toString(a));
            int csp = a[0]; // child starting pointer
            int cep = a[1]; // child ending pointer

            if(pep >= csp) {

                if(pep >= cep) {

                    psp = csp;
                    pep = cep;
                    c++;
                } else {

                    psp = csp;
                    pep = cep;
                }
            } else {

                psp = csp;
                pep = cep;
            }
        }

        return c;
    }
}