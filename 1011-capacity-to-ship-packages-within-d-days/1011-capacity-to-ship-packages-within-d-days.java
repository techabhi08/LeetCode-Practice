class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start = 0;
        int end = 0;
        for(int num : weights){
            end += num;
        }
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(isPossible(weights, days, mid)){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
    
    public boolean isPossible(int[] weights, int days, int cap){
        int sum = 0;
        int reqDays = 0;
        
        for(int weight : weights){
            if(weight > cap){
                return false;
            }
            
            sum += weight;
            if(sum > cap){
                sum = weight;
                reqDays++;
            }
        }
        
        if(sum >= 0){
            reqDays++;
        }
        return reqDays <= days;
    }
}