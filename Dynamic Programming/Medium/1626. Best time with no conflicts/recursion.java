class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] scoreMapping = new int[n][2];
        
        for(int i = 0; i < n; i++){
            scoreMapping[i][0] = ages[i];
            scoreMapping[i][1] = scores[i];
        }
        
        Arrays.sort(scoreMapping, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        
        return findMaxScore(-1, 0, scoreMapping);
    }
    
    public int findMaxScore(int prev, int index, int[][] scoreMapping){
        if(index == scoreMapping.length){
            return 0;
        }
        
        if(prev == -1 || scoreMapping[index][1] >= scoreMapping[prev][1]){
            int take = scoreMapping[index][1] + findMaxScore(index, index + 1, scoreMapping);
            int notTake = findMaxScore(prev, index + 1, scoreMapping);
            return Math.max(take, notTake);
        }
        
        return findMaxScore(prev, index + 1, scoreMapping);
    }
}
