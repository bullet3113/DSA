// https://leetcode.com/problems/online-stock-span

class StockSpanner {

    // using the previous greater element approach
    ArrayList<Integer> list; // to store the prices provided
    public StockSpanner() {
        list = new ArrayList<>();
    }
    
    public int next(int price) {
        list.add(price);
        // return previous greater element for list.size() - 1 index
        return PGE();
    }

    int PGE() {
        int n = list.size();
        int priceToday = list.get(n-1);
        int count = 1;
        for(int i = n-2; i >= 0; i--) {
            if(list.get(i) <= priceToday) count++;
            else break;
        }

        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */