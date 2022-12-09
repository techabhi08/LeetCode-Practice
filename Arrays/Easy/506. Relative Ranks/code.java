class Solution {
    public String[] findRelativeRanks(int[] score) {
        int[] temp = new int[score.length];
        int index = 0;
        for(int num : score){
            temp[index++] = num;
        }
        
        Arrays.sort(temp);
        Map<Integer, String> map = new HashMap<>();
        
        for(int i = score.length - 1; i >= 0; i--){
            if(i == score.length - 1){
                map.put(temp[i], "Gold Medal");
            }
            else if(i == score.length - 2){
                map.put(temp[i], "Silver Medal");
            }
            else if(i == score.length - 3){
                map.put(temp[i], "Bronze Medal");
            }else{
                map.put(temp[i], ""+(score.length - i));
            }
        }
        
        String[] ans = new String[score.length];
        for(int i = 0; i < score.length; i++){
            ans[i] = map.get(score[i]);
        }
        
        return ans;
        
    }
}
