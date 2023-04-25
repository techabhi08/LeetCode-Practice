class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] freq = new int[n];
        
        for(int i = 0; i < trust.length; i++){
            freq[trust[i][0] - 1]--;
            freq[trust[i][1] - 1]++;
        }
        
        
        for(int i = 0; i < freq.length; i++){
            if(freq[i] == n - 1){
                return i + 1;
            }
        }
        return -1;
    }
}
