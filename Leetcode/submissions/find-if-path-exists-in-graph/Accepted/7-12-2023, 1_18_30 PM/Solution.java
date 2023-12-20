// https://leetcode.com/problems/find-if-path-exists-in-graph

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // create graph
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj[u].add(v);
            adj[v].add(u);
        }

        // checking for path
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        boolean[] vis = new boolean[n];

        while(!q.isEmpty()) {
            int dq = q.remove();

            if(dq == destination) return true;

            if(vis[dq] == true) continue;
            vis[dq] = true;

            for(int i: adj[dq]) {
                if(!vis[i]) q.add(i);
            }
        }

        return false;


    }
}