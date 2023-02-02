class Solution {
    //This is a problem where we will use front Partitioning.
    //In this we start from the very first index and do partitions. If the partitions is
    //a palindrome then we can count 1 + resurse for the rest of string ahead of partition
    //int the same way.
    
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return findCount(0, s, dp) - 1;
    }
    
    public int findCount(int index, String s, int[] dp){
        if(index == s.length()){
            return 0;
        }
        
        if(dp[index] != -1){
            return dp[index];
        }
        
        int minCost = Integer.MAX_VALUE;
        for(int j = index; j < s.length(); j++){
            if(isPalindrome(index, j, s)){
                int cost = 1 + findCount(j + 1, s, dp);
                minCost = Math.min(minCost, cost);
            }
        }
        
        return dp[index] = minCost;
    }
    
    public boolean isPalindrome(int i, int j, String s){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
