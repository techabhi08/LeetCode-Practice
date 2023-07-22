class Solution {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        
        for(int right = 0; right < cards.length; right++){
            if(map.containsKey(cards[right])){
                ans = Math.min(ans, right - map.get(cards[right]) + 1);
            }
            map.put(cards[right], right);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}