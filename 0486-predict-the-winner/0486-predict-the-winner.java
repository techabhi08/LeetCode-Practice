class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return findMaxScore(0, nums.length - 1, nums, 0, 1) >= 0;
    }
    
    public int findMaxScore(int start, int end, int[] nums, int score, int p1Turn){
        if(start > end){
            return score;
        }
        
        if(p1Turn == 1){
            int left = findMaxScore(start + 1, end, nums, score + nums[start], 0);
            int right = findMaxScore(start, end - 1, nums, score + nums[end], 0);
            return Math.max(left, right);
        }else{
            int left = findMaxScore(start + 1, end, nums, score - nums[start], 1);
            int right = findMaxScore(start, end - 1, nums, score - nums[end], 1);
            return Math.min(left, right);
        }
    }
}