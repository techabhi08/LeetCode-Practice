class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombo(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }
    
    public void findCombo(int index, int[] arr, int target, List<Integer> inner, List<List<Integer>> ans){
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
            findCombo(i + 1, arr, target - arr[i], inner, ans);
            inner.remove(inner.size() - 1);
        }
    }
}