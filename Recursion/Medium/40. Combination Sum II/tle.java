class Solution {
    //This is a brute force kind of solution solved using Combination sum1 problem
    //But will give TLE, hence we will go for an optimised approach.
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> list = new HashSet<>();
        Arrays.sort(candidates);
        findCombinations(0, target, candidates, new ArrayList<>(), list);
        
        List<List<Integer>> result = new ArrayList<>();
        for(List<Integer> item : list){
            result.add(item);
        }
        return result;
    }
    
    public void findCombinations(int index, int target, int[] arr, List<Integer> inner, Set<List<Integer>> list){
        if(index == arr.length){
            if(target == 0){
                list.add(new ArrayList<>(inner));
            }
            return;
        }
        
        if(arr[index] <= target){
            inner.add(arr[index]);
            findCombinations(index + 1, target - arr[index], arr, inner, list);
            inner.remove(inner.size() - 1);
        }
        findCombinations(index + 1, target, arr, inner, list);
    }
}
