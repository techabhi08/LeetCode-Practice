class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findAns(0, target, candidates, ans, new ArrayList<>());
        
        return ans;
    }
    
    public void findAns(int index, int target, int[] arr, List<List<Integer>> ans, List<Integer> inner){
        if(target == 0){
            ans.add(new ArrayList<>(inner));
            return;
        }
        
        for(int i = index; i < arr.length; i++){
            if(i > index && arr[i] == arr[i - 1]){
                continue;
            }
            if(arr[i] > target){
                break;
            }
            inner.add(arr[i]);
            findAns(i + 1, target - arr[i], arr, ans, inner);
            inner.remove(inner.size() - 1);
        }
    }
}