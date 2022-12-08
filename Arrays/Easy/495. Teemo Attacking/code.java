class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int time = 0;
        for(int i = 0; i < timeSeries.length - 1; i++){
            if(timeSeries[i + 1] <= timeSeries[i] + duration - 1){
                time += timeSeries[i + 1] - timeSeries[i];
            }else{
                time += duration;
            }
        }
        time += duration;
        return time;
    }
}
