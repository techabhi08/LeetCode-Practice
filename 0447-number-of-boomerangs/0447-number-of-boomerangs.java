class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for(int i = 0; i < points.length; i++){
            Map<Long, Integer> map = new HashMap<>();
            for(int j = 0; j < points.length; j++){
                long dist = (points[j][0] - points[i][0])*(points[j][0] - points[i][0]) + 
                    (points[j][1] - points[i][1])*(points[j][1] - points[i][1]);
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }
            
            for(int v : map.values()){
                ans += v * (v - 1);
            }
        }
        return ans;
    }
}