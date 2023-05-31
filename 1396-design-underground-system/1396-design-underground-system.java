class Pair{
    String start;
    int time;
    
    Pair(String station, int time){
        this.start = station;
        this.time = time;
    }
}
class UndergroundSystem {
    HashMap<Integer, Pair> checkIn;
    HashMap<String, HashMap<String, int[]>> time;
    
    public UndergroundSystem() {
        checkIn = new HashMap<>();
        time = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIn.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair start_detail = checkIn.get(id);
        time.putIfAbsent(start_detail.start, new HashMap<>());
        
        time.get(start_detail.start).putIfAbsent(stationName, new int[2]);
        time.get(start_detail.start).get(stationName)[0]++;
        time.get(start_detail.start).get(stationName)[1] += (t - start_detail.time);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        HashMap<String, int[]> entries = time.get(startStation);
        
        int[] arr = entries.get(endStation);
        return (double) arr[1] / arr[0];
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */