// https://leetcode.com/problems/find-median-from-data-stream

class MedianFinder {

    PriorityQueue<Integer> pqSmallMax;
    PriorityQueue<Integer> pqLargeMin;

    public MedianFinder() {
        pqSmallMax = new PriorityQueue<>((a, b) -> b - a);
        pqLargeMin = new PriorityQueue<>();    
    }
    
    public void addNum(int num) {
        if(pqLargeMin.isEmpty() || num <= pqLargeMin.peek()) {
            pqSmallMax.add(num);
        } else {
            pqLargeMin.add(num);
        }

        if((pqSmallMax.size() - pqLargeMin.size()) > 1) {
            pqLargeMin.add(pqSmallMax.poll());
        }
    }
    
    public double findMedian() {
        // System.out.println(pqSmallMax.size() + " " + pqLargeMin.size());
        if((pqSmallMax.size() + pqLargeMin.size()) % 2 == 0) {
            return (double)(pqSmallMax.peek() + pqLargeMin.peek()) / 2;
        }

        return (pqSmallMax.size() > pqLargeMin.size()) ? pqSmallMax.peek() : pqLargeMin.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */