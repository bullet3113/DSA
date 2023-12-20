// https://leetcode.com/problems/course-schedule-ii

class Solution {
    ArrayList<Integer> adj[];
    public int[] findOrder(int n, int[][] prerequisites) {
        adj = new ArrayList[n];
		if(helper(n, prerequisites)) {
			Stack<Integer> st = new Stack<>();
			boolean[] vis = new boolean[n];
			int arr[] = new int[n];
			int check = Integer.MAX_VALUE;
			for(int i = 0; i < n; i++) {
				if(!vis[i]) {
					dfs(st, i, vis);
				}
				// System.out.println(st.size());
				// if(st.size() == n)
				// {
				// 	int l = 0;
				// 	Stack<Integer> st2 = new Stack<>();
				// 	while(!st.isEmpty()) {
				// 	st2.push(st.pop());
				// }

				// 	if(st2.peek() < check) {
				// 		while(!st2.isEmpty()) {
				// 	arr[l++] = st2.pop();
				// }	
				// 	}
					
				// }
			}
			
			
			int i = 0;
			// System.out.println(st.size());
			while(!st.isEmpty()) {
				arr[i++] = st.pop();
			}

			return arr;
		} 

		return new int[]{};
    }

    void dfs(Stack<Integer> st, int src, boolean[] vis) {
		vis[src] = true;
		// System.out.println(src);

		for(int i: adj[src]) {
			if(!vis[i]) dfs(st, i, vis);
		}

		st.push(src);
	}

	boolean helper(int n, int[][] prerequisites) {
		
		for(int i = 0; i < n; i++) adj[i] = new ArrayList<Integer>();
		for(int i = 0; i < prerequisites.length; i++) {
			adj[prerequisites[i][1]].add(prerequisites[i][0]);
		}

		Queue<Integer> q = new LinkedList<>();
		int[] indegree = new int[n];

		// storing values of indegrees
		for(int i = 0; i < n; i++) {
			for(int it : adj[i]) {
				indegree[it]++;
			}
		}

		for(int i = 0; i < n; i++) {
			if(indegree[i] == 0) q.add(i);
		}
		
		ArrayList<Integer> ans = new ArrayList<>();
	
		while(!q.isEmpty()) {
			int dq = q.remove();
			ans.add(dq);

			for(int it : adj[dq]) {
				indegree[it]--;
				if(indegree[it] == 0) q.add(it);
			}
		}

		if(ans.size() == n) return true;

		return false;
	}
}