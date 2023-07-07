class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(findLongest(answerKey, k, 'T'), findLongest(answerKey, k, 'F'));
    }
    
    public int findLongest(String str, int k, char ch){
        int left = 0;
        int ans = 0;
        
        for(int right = 0; right < str.length(); right++){
            if(str.charAt(right) != ch){
                k--;
            }
            while(k < 0){
                if(str.charAt(left) == ch){
                    left++;
                }else{
                    k++;
                    left++;
                }
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}