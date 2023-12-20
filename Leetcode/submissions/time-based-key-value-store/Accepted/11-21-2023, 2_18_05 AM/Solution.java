// https://leetcode.com/problems/time-based-key-value-store

class TimeMap {

    Map<String, List<pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(new pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        
        if(!map.containsKey(key) || map.get(key).isEmpty()) return "";
        List<pair> list = map.get(key);

        int i = 0;
        int j = list.size()-1;

        while(i <= j) {
            int mid = i + (j - i) / 2;
            int time = list.get(mid).time;
            
            if(time <= timestamp) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        if(j == -1) return "";
        return list.get(j).val;
    }
}

class pair {
    String val;
    int time;

    public pair(String val, int time) {
        this.val = val;
        this.time = time;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */