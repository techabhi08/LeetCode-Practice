class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        findSum(1, k, n, new ArrayList<>(), ans);
        return ans;
    }
    
    public void findSum(int start, int k, int n, List<Integer> inner, List<List<Integer>> ans){
        if(inner.size() == k && n == 0){
            ans.add(new ArrayList<>(inner));
            return;
        }
        
        for(int i = start; i <= 9; i++){
            inner.add(i);
            findSum(i + 1, k, n - i, inner, ans);
            inner.remove(inner.size() - 1);
        }
    }
}