class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = rocks.length;
        int[] remaining = new int[n];
        
        for(int i = 0; i < n; i++){
            remaining[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(remaining);
        
        int count = 0;
        for(int i = 0; i < n; i++){
            if(remaining[i] <= additionalRocks){
                additionalRocks -= remaining[i];
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}
