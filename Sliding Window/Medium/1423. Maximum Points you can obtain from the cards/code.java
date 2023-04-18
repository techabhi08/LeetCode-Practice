class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0;
        
        for(int i = 0; i < k; i++){
            sum += cardPoints[i];
        }
        
        int ans = sum;
        int right = cardPoints.length - 1;
        for(int left = k - 1; left >= 0; left--){
            sum += cardPoints[right] - cardPoints[left];
            right--;
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
