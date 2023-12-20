// https://leetcode.com/problems/lru-cache

class LRUCache {
    int capacity;
    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, Integer> records = new HashMap<>();
    ArrayList<Integer> list = new ArrayList<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        // int idx = records.get(key);
        list.remove(Integer.valueOf(key));
        list.add(key);
        // records.put(key, list.size()-1);
        return map.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        if(capacity <= 0) {
            if(map.containsKey(key)) {
                map.put(key, value);
                return;
            }
            int tempKey = list.get(0);
            list.remove(0);
            // records.remove(tempKey);
            map.remove(tempKey);
        }

        map.put(key, value);
        list.add(key);
        // records.put(key, list.size()-1);
        capacity--;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */