// https://leetcode.com/problems/course-schedule

class Solution {
    public boolean canFinish(int n, int[][] p) {
        
        // create graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < p.length; i++) {
            adj.get(p[i][1]).add(p[i][0]);
        }

        // create indegree array
        int[] indegree = new int[n];

        for(int i = 0; i < n; i++) {
            for(int it: adj.get(i)) {
                indegree[it]++;
            }
        }

        // create queue
        Queue<Integer> q = new LinkedList<>();

        // adding 0 indegrees to queue
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) q.add(i);
        }

        // logic simple bfs
        while(!q.isEmpty()) {
            int dq = q.remove();
n--;
            for(int it: adj.get(dq)) {
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }

            
        }

        return n == 0;
    }
}