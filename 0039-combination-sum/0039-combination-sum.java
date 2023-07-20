class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findSum(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
    
    public void findSum(int index, int[] arr, int target, List<List<Integer>> ans, List<Integer> inner){
        if(index == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(inner));
            }
            return;
        }
        
        if(arr[index] <= target){
            inner.add(arr[index]);
            findSum(index, arr, target - arr[index], ans, inner);
            inner.remove(inner.size() - 1);
        }
        findSum(index + 1, arr, target, ans, inner);
    }
}