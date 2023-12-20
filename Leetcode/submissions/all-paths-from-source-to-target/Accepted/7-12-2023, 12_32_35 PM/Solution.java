// https://leetcode.com/problems/all-paths-from-source-to-target

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> list = new ArrayList<>();

        boolean[] vis = new boolean[graph.length];
        getPaths(graph, 0, graph.length-1, vis, list, new ArrayList<>());

        return list;
    }

    void getPaths(int[][] graph, int src, int dest, boolean[] vis, List<List<Integer>> list, List<Integer> temp) {

        temp.add(src);
        if(src == dest) {
            list.add(new ArrayList<>(temp));
            // return;
        }

        vis[src] = true;

        for(int i: graph[src]) {
            
            if(!vis[i]) getPaths(graph, i, dest, vis, list, temp);
            
        }

        vis[src] = false;
        temp.remove(temp.size() - 1);
    } 
}