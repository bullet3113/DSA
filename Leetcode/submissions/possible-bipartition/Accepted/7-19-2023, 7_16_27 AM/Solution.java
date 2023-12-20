// https://leetcode.com/problems/possible-bipartition

class Solution {
    public boolean possibleBipartition(int n, int[][] d) {
        
        // create graph
		ArrayList<Integer>[] adj = new ArrayList[n];
		for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();

		for(int i = 0; i < d.length; i++) {
			int u = d[i][0] - 1;
			int v = d[i][1] - 1;

			adj[u].add(v);
			adj[v].add(u);
		}

        int[] vis = new int[n];
        Arrays.fill(vis, -1);

        for(int i = 0; i < n; i++) {
            if(vis[i] == -1) if(!bfs(adj, i, vis)) return false;
        }

        return true;
    }

    boolean bfs(ArrayList<Integer>[] adj, int src, int[] vis) {
        Queue<pair> q = new LinkedList<>();

        q.add(new pair(src, 0));

        while(!q.isEmpty()) {
            pair dq = q.remove();

            if(vis[dq.x] != -1) {
                if(vis[dq.x] != dq.level) return false;
            } else {
                vis[dq.x] = dq.level;
            }

            for(int i: adj[dq.x]) {
                if(vis[i] == -1) q.add(new pair(i, dq.level + 1));
            }
        }

        return true;
    }
}

class pair {
    int x;
    int level;

    public pair(int x, int level) {
        this.x = x;
        this.level = level;
    }
}