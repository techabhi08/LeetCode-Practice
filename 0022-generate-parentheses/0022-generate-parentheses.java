class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        find(0, 0, "", n, ans);
        return ans;
    }
    
    public void find(int start, int end, String str, int n, List<String> ans){
        if(str.length() == n * 2){
            ans.add(str);
            return;
        }
        
        if(start < n){
            find(start + 1, end, str + "(", n, ans);
        }
        if(end < start){
            find(start, end + 1, str + ")", n, ans);
        }
    }
}