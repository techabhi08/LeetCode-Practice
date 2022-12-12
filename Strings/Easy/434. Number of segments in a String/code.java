class Solution {
    public int countSegments(String s) {
        String trims = s.trim();
        if(trims.equals("")){
            return 0;
        }
        return trims.split("\\s+").length;
    }
}
