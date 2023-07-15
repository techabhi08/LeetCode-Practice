class Solution {
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];
        int[] curr = new int[n];
        prev[0] = 1;
        curr[0] = 1;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    curr[j] = 1;
                }else{
                    int left = 0, up = 0;
                    if(j - 1 >= 0)left = curr[j - 1];
                    if(i - 1 >= 0) up = prev[j];

                    curr[j] = left + up;
                }
            }
            prev = (int[])curr.clone();
        }
        return prev[n - 1];
    }
}