class MyHashMap {
    List<List<int[]>> arr;
        
    /** Initialize your data structure here. */
    public MyHashMap() {
        arr = new ArrayList<List<int[]>>();
        for (int i = 0; i < 769; i++) {
            arr.add(new ArrayList<int[]>());
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int idx = key % 769;
        List<int[]> bucket = arr.get(idx);
        
        for (int i = 0; i < bucket.size(); i++) {
            int[] pairs = bucket.get(i);
            if (pairs[0] == key) {
                pairs[1] = value;
                bucket.set(i, pairs);
                arr.set(idx, bucket);
                return;
            }
        }
        
        int[] add = new int[]{key, value};
        bucket.add(add);
        arr.set(idx, bucket);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int idx = key % 769;
        List<int[]> bucket = arr.get(idx);
        
        for (int i = 0; i < bucket.size(); i++) {
            int[] pairs = bucket.get(i);
            if (pairs[0] == key) {
                return pairs[1];
            }
        }
        
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int idx = key % 769;
        List<int[]> bucket = arr.get(idx);
        
        for (int i = 0; i < bucket.size(); i++) {
            int[] pairs = bucket.get(i);
            if (pairs[0] == key) {
                bucket.set(i, bucket.get(bucket.size() - 1));
                bucket.remove(bucket.size() - 1);
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */