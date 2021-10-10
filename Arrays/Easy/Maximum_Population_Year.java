class Solution {
    public int maximumPopulation(int[][] logs) {
        int n = logs.length;
        int[] year = new int[2051];
        
        for(int i = 0; i < n; i++){
            year[logs[i][0]] +=1;
            year[logs[i][1]] -= 1;
        }
        
        int maxPop = year[1950];
        int maxYear = 1950;
        for(int j = 1951; j < year.length; j++){
            year[j] += year[j - 1];
            
            if(year[j] > maxPop){
                maxPop = year[j];
                maxYear = j;
            }
        }
        return maxYear;
        
    }
}
