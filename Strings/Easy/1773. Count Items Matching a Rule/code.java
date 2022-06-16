class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        int idx = 0;
        
        if(ruleKey.equals("type")){
            idx = 0;
        }else if(ruleKey.equals("color")){
            idx = 1;
        }else{
            idx = 2;
        }
        
        for(List<String> item : items){
            if(item.get(idx).equals(ruleValue)){
                count++;
            }
        }
        return count;
    }
}
