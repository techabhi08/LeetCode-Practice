class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] temp = new int[n + 1];
        
        for(int i = 0; i < n; i++){
            if(citations[i] >= n){
                temp[n]++;
            }else{
                temp[citations[i]]++;
            }
        }
        
        int count = 0;
        for(int i = n; i >= 0; i--){
            count += temp[i];
            if(count >= i){
                return i;
            }
        }
        return 0;
    }
}