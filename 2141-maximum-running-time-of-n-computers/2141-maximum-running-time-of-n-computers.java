class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for(int num : batteries){
            sum += num;
        }
        long start = 0;
        long end = sum / n;
        
        long max = 0;
        while(start <= end){
            long mid = start + (end - start) / 2;
            if(isPossible(n, batteries, mid)){
                max = Math.max(max, mid);
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        
        return max;
    }
    
    public boolean isPossible(int n, int[] batteries, long time){
        long sum = 0;
        long target = n * time;
        
        for(int num : batteries){
            if(num < time){
                sum += num;
            }else{
                sum += time;
            }
            
            if(sum >= target){
                return true;
            }
        }
        return sum >= target;
    }
}