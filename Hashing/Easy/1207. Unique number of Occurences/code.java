class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        for(int num : arr){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        Set<Integer> set = new HashSet<>(freq.values());
        
        if(set.size() == freq.size()){
            return true;
        }
        return false;
    }
}
