class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        
        findAns(1, k, n, list, new ArrayList<>());
        return list;
    }
    
    public void findAns(int index, int k, int target, List<List<Integer>> ans, List<Integer> inner){
        if(inner.size() == k && target == 0){
            ans.add(new ArrayList<>(inner));
            return;
        }
        
        for(int i = index; i <= 9; i++){
            if(i > target){
                break;
            }
            inner.add(i);
            findAns(i + 1, k, target - i, ans, inner);
            inner.remove(inner.size() - 1);
        }
    }
}