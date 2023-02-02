class Solution {
    //This is a problem where we will use front Partitioning.
    //In this we start from the very first index and do partitions. If the partitions is
    //a palindrome then we can count 1 + resurse for the rest of string ahead of partition
    //int the same way.
    
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        
        for(int index = n - 1; index >= 0; index--){
            int minCost = Integer.MAX_VALUE;
            for(int j = index; j < s.length(); j++){
                if(isPalindrome(index, j, s)){
                    int cost = 1 + dp[j + 1];
                    minCost = Math.min(minCost, cost);
                }
            }
            dp[index] = minCost;
        }
        return dp[0] - 1;
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
