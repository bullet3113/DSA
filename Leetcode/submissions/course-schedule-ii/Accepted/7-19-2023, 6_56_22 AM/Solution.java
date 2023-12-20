// https://leetcode.com/problems/course-schedule-ii

class Solution {
    public int[] findOrder(int n, int[][] p) {
        // adjacency list
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for(int i = 0; i < p.length; i++) {
            adj[p[i][1]].add(p[i][0]);
        }
        
        // creating indegree array
        int[] indegree = new int[n];

        for(int i = 0; i < n; i++) {
            for(int it: adj[i]) {
                indegree[it]++;
            }
        }

        int[] topoSort = new int[n];
        Queue<Integer> q = new LinkedList<>();

        // adding all elements to q whose indegree is 0
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) q.add(i);
        }

        int c = 0;

        while(!q.isEmpty()) {
            int dq = q.remove();

            topoSort[c++] = dq;

            for(int it: adj[dq]) {
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }

        if(c == n) return topoSort;

        return new int[] {};
    }
}