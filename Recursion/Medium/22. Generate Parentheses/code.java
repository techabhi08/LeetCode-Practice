class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        findPairs(n, "", 0, 0, ans);
        return ans;
    }
    
    public void findPairs(int n, String str, int start, int end, List<String> ans){
        if(str.length() == n * 2){
            ans.add(str);
            return;
        }
        
        if(start < n){
            findPairs(n, str + "(", start + 1, end, ans);
        }
        if(end < start){
            findPairs(n, str + ")", start , end + 1, ans);
        }
    }
}
