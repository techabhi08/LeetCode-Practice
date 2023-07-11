class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(int i = 0; i < moveFrom.length; i++){
            int numOfMarbles = map.get(moveFrom[i]);
            map.remove(moveFrom[i]);
            map.put(moveTo[i], map.getOrDefault(moveTo[i], 0) + numOfMarbles);
        }
        
        List<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            ans.add(entry.getKey());
        }
        
        Collections.sort(ans);
        return ans;
    }
}