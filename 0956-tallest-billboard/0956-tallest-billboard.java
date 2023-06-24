class Solution {
    public int tallestBillboard(int[] rods) {
        int n = rods.length;
        Map<Pair, Integer> dp = new HashMap<>();
        return findMax(0, 0, rods, dp);
    }
    
    public int findMax(int index, int diff, int[] rods, Map<Pair, Integer> dp){
        if(index == rods.length){
            return diff == 0 ? 0 : Integer.MIN_VALUE;
        }
        
        Pair key = new Pair(index, diff);
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        
        int ans = Math.max(findMax(index + 1, diff + rods[index], rods, dp) + rods[index], 
                        Math.max(findMax(index + 1, diff - rods[index], rods, dp), 
                                findMax(index + 1, diff, rods, dp)));
        dp.put(key, ans);
        return ans;
    }
}