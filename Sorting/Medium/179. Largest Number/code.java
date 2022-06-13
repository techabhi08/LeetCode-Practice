class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null){
            return "";
        }
        String[] str = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            str[i] = nums[i] + "";
        }
        
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String a, String b){
                String s1 = a + b;
                String s2 = b + a;
                return s1.compareTo(s2);
            }
        });
        
        if(str[str.length - 1].charAt(0) == '0'){
            return "0";
        }
        String ans = new String();
        for(int i = 0; i < str.length; i++){
            ans = str[i] + ans;
        }
        return ans;
    }
}
