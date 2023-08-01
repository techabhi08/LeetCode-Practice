class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result =  new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        
        findCombinations(1, n, k, combination, result);
        return result;
    }
    
    public void findCombinations(int num, int n, int k, List<Integer> combination, List<List<Integer>> result){
        if(num > n + 1){
            return;
        }
        
        if(combination.size() == k){
            result.add(new ArrayList<>(combination));
            return;
        }
        
        combination.add(num);
        findCombinations(num + 1, n, k, combination, result);
        
        combination.remove(combination.size() - 1);
        findCombinations(num + 1, n, k, combination, result);
    }
}