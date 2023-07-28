class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        int left = 0;
        int right = k - 1;
        while(right < s.length()){
            String str = s.substring(left, right + 1);
            set.add(str);
            right++;
            left++;
        }
        
        return set.size() == (int)Math.pow(2, k);
    }
}