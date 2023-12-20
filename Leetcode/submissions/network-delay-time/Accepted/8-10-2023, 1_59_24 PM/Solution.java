// https://leetcode.com/problems/network-delay-time

class Solution {
    public class Edge{
        int v = 0;
        int w = 0;
        Edge(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
    public class Pair{
        int vtx = 0;
        int wsf = 0;
        Pair(int vtx, int wsf){
            this.vtx = vtx;
            this.wsf = wsf;
        }
    }
    public int dijkstraAlgo(ArrayList<Edge>[] graph, int src){
        int[] dist = new int[graph.length + 1];
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            return a.wsf - b.wsf;
        });
        pq.add(new Pair(src, 0));
        while(pq.size() != 0){
            Pair p = pq.remove();
            for(Edge e : graph[p.vtx]){
                if(p.wsf + e.w < dist[e.v]) {
                    dist[e.v] = p.wsf + e.w;
                    pq.add(new Pair(e.v, p.wsf + e.w));
                }
            }
        }
        int ans = 0;
        for(int i = 1; i < graph.length; i++){
            if(dist[i] == (int)1e9){ 
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Edge>[] graph = new ArrayList[n + 1];
        for(int i = 0 ; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] e : times){
            graph[e[0]].add(new Edge(e[1], e[2]));
        }
        return dijkstraAlgo(graph, k);
    }
}