// https://leetcode.com/problems/top-k-frequent-elements

class Solution {
    public int[] topKFrequent(int[] arr, int k) {
        // using hashmap and prioriry queue

		Map<Integer, Integer> map = new HashMap<>();
		int n = arr.length;

		// using hashmap to store element frequency wise
		for(int i = 0; i < n; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		// using max priority queue to sort hash map according to freq.

		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
			
			return map.get(b) - map.get(a);
		});

		for(int i: map.keySet()) {
			pq.add(i);
		}

		int[] ans = new int[k];
		for(int i = 0; i < k; i++) ans[i] = pq.remove();

		return ans;
    }
}