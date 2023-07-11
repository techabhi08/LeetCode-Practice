class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findAns(0, target, candidates, new ArrayList<>(), ans);
        return ans;
    }
    
    public void findAns(int index, int target, int[] arr, List<Integer> inner, List<List<Integer>> ans){
        if(index == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(inner));
            }
            return;
        }
        
        if(arr[index] <= target){
            inner.add(arr[index]);
            findAns(index, target - arr[index], arr, inner, ans);
            inner.remove(inner.size() - 1);
        }
        
        findAns(index + 1, target, arr, inner, ans);
    }
}