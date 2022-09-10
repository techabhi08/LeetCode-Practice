class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sumWeight = 0;
        for(int i = 0; i < weights.length; i++){
            sumWeight += weights[i];
        }
        
        int low = 1;
        int high = sumWeight;
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(isPossible(weights, days, mid)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    
    public boolean isPossible(int[] weights, int days, int currCapacity){
        int reqDays = 0;
        int weightSum = 0;
        for(int i = 0; i < weights.length; i++){
            if(weights[i] > currCapacity){
                return false;
            }
            weightSum += weights[i];
            if(weightSum > currCapacity){
                weightSum = weights[i];
                reqDays++;
            }
        }
        if(weightSum  > 0){
            reqDays++;
        }
        return reqDays <= days;
    }
}
