class UndergroundSystem {
    Map<Integer,Integer> checkIn;
    Map<Integer,String> src;
    Map<String,int[]> times;
    public UndergroundSystem() {
        checkIn = new HashMap<>();
        times = new HashMap<>();
        src = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIn.put(id, t);
        src.put(id, stationName);
    }
    
    public void checkOut(int id, String stationName, int t) {
        int timeIn = checkIn.get(id);
        String loc = src.get(id);
        String strId = loc + stationName;
        int[] existing = times.getOrDefault(strId, new int[2]);
        existing[0] += 1;
        existing[1] += t - timeIn;
        times.put(strId, existing);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        int[] time = times.get(startStation + endStation);
        return (double) time[1] / time[0];
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */