// https://leetcode.com/problems/k-closest-points-to-origin

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        int n = points.length;
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> {
            if(a.dist > b.dist) return 1;
            else return -1;
        });

        for(int i = 0; i < n; i++) {
            pq.add(new pair(points[i][0], points[i][1]));
        }

        int[][] ans = new int[k][2];
        int i = 0;
        while(k > 0) {
            pair p = pq.remove();
            ans[i][0] = p.x;
            ans[i][1] = p.y;

            k--;
            i++;
        }

        return ans;
    }
}

class pair {
    int x;
    int y;
    double dist;

    public pair(int x, int y) {
        this.x = x;
        this.y = y;
        this.dist = Math.sqrt((double)((this.x * this.x) + (this.y * this.y)));
    }
}