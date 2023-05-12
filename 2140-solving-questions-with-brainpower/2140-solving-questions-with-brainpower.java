class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        
        return findMax(0, questions, dp);
    }
    
    public long findMax(int index, int[][] questions, long[] dp){
        if(index >= questions.length){
            return 0;
        }
        
        if(dp[index] > 0){
            return dp[index];
        }
        
        long points = 0;
        points += Math.max(questions[index][0] + findMax(index + questions[index][1] + 1, questions, dp), findMax(index + 1, questions, dp));
        
        return dp[index] = points;
    }
}