class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        int maxi = 1;
        
        for(int num : arr){
            if(map.containsKey(num - difference)){
                map.put(num, map.get(num - difference) + 1);
            }else{
                map.put(num, 1);
            }
            
            maxi = Math.max(maxi, map.get(num));
        }
        return maxi;
    }
}