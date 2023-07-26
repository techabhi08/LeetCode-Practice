class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int left = 1;
        int right = (int)1e8;
        
        while(left < right){
            int mid = left + (right - left) / 2;
            if(isPossible(dist, hour, mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        
        return right == (int)1e8 ? -1 : right;
    }
    
    public boolean isPossible(int[] dist, double hour, int speed){
        int time = 0;
        for(int i = 0; i < dist.length - 1; i++){
            time += Math.ceil((double)dist[i] / speed);
        }
        return time + (double) dist[dist.length - 1] / speed <= hour;
    }
}