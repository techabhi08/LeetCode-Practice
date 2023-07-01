class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m * k > bloomDay.length){
            return -1;
        }
        
        int start = 0;
        int end = 1000000000;
        int ans = -1;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(isPossible(bloomDay, m, k, mid)){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return ans;
    }
    
    public boolean isPossible(int[] bloomDay, int m, int k, int mid){
        int flowers = 0;
        int bouquet = 0;
        
        for(int day : bloomDay){
            if(day <= mid){
                flowers++;
            }else{
                flowers = 0;
            }
            
            if(flowers == k){
                bouquet++;
                flowers = 0;
            }
            if(bouquet == m){
                return true;
            }
        }
        return bouquet >= m;
    }
}