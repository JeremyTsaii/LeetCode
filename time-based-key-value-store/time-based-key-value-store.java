class Pair {
    String val;
    int time;
    
    public Pair(String val, int time) {
        this.val = val;
        this.time = time;
    }
}

class TimeMap {
    Map<String, List<Pair>> map;
    
    /** Initialize your data structure here. */
    public TimeMap() {
        this.map = new HashMap<String, List<Pair>>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair> arr = this.map.getOrDefault(key, new ArrayList<Pair>());
        arr.add(new Pair(value, timestamp));
        this.map.put(key, arr);
    }
    
    public String get(String key, int timestamp) {
        if (!this.map.containsKey(key)) {
            return "";
        }
        
        List<Pair> arr = this.map.get(key);
        return binSearch(arr, timestamp);
    }
    
    private String binSearch(List<Pair> arr, int time) {
        int left = 0, right = arr.size() - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            Pair p = arr.get(mid);
            if (p.time == time) {
                return p.val;
            } else if (p.time < time) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return left - 1 == -1 ? "" : arr.get(left-1).val;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */