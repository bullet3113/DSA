// https://leetcode.com/problems/last-stone-weight

class Solution {
    public int lastStoneWeight(int[] stones) {
        
        int n = stones.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for(int i: stones) pq.add(i);

        while(pq.size() > 1) {

            int y = pq.remove();
            int x = pq.remove();

            if(x == y) continue;
            else {
                pq.add(y-x);
            }
        }

        return pq.peek() != null ? pq.peek() : 0;
    }
}