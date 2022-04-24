class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        int ruleIndex = 0;
        if(ruleKey.equals("color")){
            ruleIndex = 1;
        } else if (ruleKey.equals("name")) {
            ruleIndex = 2;
        }
        for(List<String> item : items){
            if(item.get(ruleIndex).equals(ruleValue)){
                count++;
            }
        }
        return count;
    }
}
