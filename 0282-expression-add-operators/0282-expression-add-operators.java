class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        solve(num, target, ans, 0, "", 0, 0);
        return ans;
    }
    
    public void solve(String num, int target, List<String> ans, int index, String str, long sum, long prevNum){
        if(index == num.length()){
            if(sum == target){
                ans.add(str);
                return;
            }
        }
        
        for(int i = index; i < num.length(); i++){
            if(index != i && num.charAt(index) == '0'){
                break;
            }
            
            long curr = Long.parseLong(num.substring(index, i + 1));
            if(index == 0){
                solve(num, target, ans, i + 1, str + curr, curr, curr);
            }else{
                solve(num, target, ans, i + 1, str + "+" + curr, sum + curr, curr);
                solve(num, target, ans, i + 1, str + "-" + curr, sum - curr, -curr);
                
                long newVal = (sum - prevNum) + (prevNum * curr);
                solve(num, target, ans, i + 1, str + "*" + curr, newVal, prevNum * curr);
            }
        }
    }
}