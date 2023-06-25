class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for(String s : words){
            String sb = new StringBuilder(s).reverse().toString();
            if(map.containsKey(sb)){
                map.put(sb, map.get(sb) + 1);
            }else{
                map.put(s, 0);
            }
        }
        
        int ans = 0;
        for(int value : map.values()){
            ans += value;
        }
        return ans;
    }
}