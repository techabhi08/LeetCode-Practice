class Solution {
    //In this appreach we will sort the array and will avoid duplicate at same level.
    //Hence we reduce the recursion call for the duplicates on the same level.
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0, target, candidates, new ArrayList<>(), list);
        return list;
    }
    
    public void findCombinations(int index, int target, int[] arr, List<Integer> inner, List<List<Integer>> list){
        if(target == 0){
            list.add(new ArrayList<>(inner));
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
            findCombinations(i + 1, target - arr[i], arr, inner, list);
            inner.remove(inner.size() - 1);
        }
    }
}
