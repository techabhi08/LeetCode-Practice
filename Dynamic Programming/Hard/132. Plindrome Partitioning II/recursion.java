class Solution {
    //This is a problem where we will use front Partitioning.
    //In this we start from the very first index and do partitions. If the partitions is
    //a palindrome then we can count 1 + resurse for the rest of string ahead of partition
    //int the same way.
    
    public int minCut(String s) {
        return findCount(0, s) - 1;
    }
    
    public int findCount(int index, String s){
        if(index == s.length()){
            return 0;
        }
        
        int minCost = Integer.MAX_VALUE;
        for(int j = index; j < s.length(); j++){
            if(isPalindrome(index, j, s)){
                int cost = 1 + findCount(j + 1, s);
                minCost = Math.min(minCost, cost);
            }
        }
        
        return minCost;
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
