class Solution {
    public int findKthNumber(int n, int k) {
        long prefix = 1;
        long count = 1;
        while(count < k){
            long prefixWithRangeCount = findPrefixCount(prefix, prefix + 1, n);
            
            if(prefixWithRangeCount + count <= k){
                count += prefixWithRangeCount;
                prefix++;
            }else{
                prefix *= 10;
                count++;
            }
        }
        
        return (int)prefix;
    }
    
    public long findPrefixCount(long startPrefix, long endPrefix, int max){
        long count = 0;
        while(startPrefix <= max){
            count += Math.min(max + 1, endPrefix) - startPrefix;
            startPrefix *= 10;
            endPrefix *= 10;
        }
        return count;
    }
}