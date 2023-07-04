class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        findAns(0, s, new ArrayList<>(), ans);
        return ans;
    }
    
    public void findAns(int index, String s, List<String> inner, List<List<String>> ans){
        if(index == s.length()){
            ans.add(new ArrayList<>(inner));
            return;
        }
        
        for(int i = index; i < s.length(); i++){
            if(isPalindrome(index, i, s)){
                inner.add(s.substring(index, i + 1));
                findAns(i + 1, s, inner, ans);
                inner.remove(inner.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(int start, int end, String s){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}