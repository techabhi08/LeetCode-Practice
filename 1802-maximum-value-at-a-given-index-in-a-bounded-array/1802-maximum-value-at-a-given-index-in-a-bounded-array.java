class Solution {
    public int maxValue(int n, int index, int maxSum) {
        long lo=1 , hi = Integer.MAX_VALUE , result=0;
        
        while(lo<=hi){
            
            long mid= lo + (hi-lo)/2;
            
            long left=Sum(Math.min(index,mid-1),mid); 
            left+=Math.max(0,index-mid+1);
            
            long right=Sum(Math.min(n-index-1,mid-1),mid);
            right+=Math.max(0,(n-index-mid));
                
            if(left+right+mid<=maxSum){
                result=mid;
                lo=mid+1;
            }else{
                hi=mid-1;
            }    
        }
        
        return (int)result;
    }
    
    private long Sum(long noofElement,long x){
        return x*(noofElement) - ((noofElement*(noofElement+1))/2);
    }
}