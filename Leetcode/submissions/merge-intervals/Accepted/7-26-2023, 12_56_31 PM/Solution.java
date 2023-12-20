// https://leetcode.com/problems/merge-intervals

class Solution {
    public int[][] merge(int[][] intervals) {
        // sorting the intervals array considering starting index
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        int psp = intervals[0][0];
        int pep = intervals[0][1];

        Stack<int[]> stack = new Stack<>(); // for storing ans [si, ei]

        for(int i = 1; i < intervals.length; i++) {
            int csp = intervals[i][0];
            int cep = intervals[i][1];

            if(csp <= pep) {
                if(cep > pep)
                pep = cep;
            } else {
                int[] temp = {psp, pep};
                stack.push(temp);
                psp = csp;
                pep = cep;
            }
        }

        stack.push(new int[]{psp, pep});

        int[][] ans = new int[stack.size()][2];

        for(int i = stack.size()-1; i >= 0; i--) {
            int[] temp = stack.pop();
            ans[i][0] = temp[0];
            ans[i][1] = temp[1];
        }

        return ans;
    }
}