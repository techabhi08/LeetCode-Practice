class Solution {
    public String[] findWords(String[] words) {
        String first = "qwertyuiop";
        String second = "asdfghjkl";
        String third = "zxcvbnm";
        
        ArrayList<String> list = new ArrayList<>();
        for(String str : words){
            int count1 = 0;
            int count2 = 0;
            int count3 = 0;
            int len = str.length();
            for(char c : str.toLowerCase().toCharArray()){
                if(first.indexOf(c) != -1){
                    count1++;
                }
                if(second.indexOf(c) != -1){
                    count2++;
                }
                if(third.indexOf(c) != -1){
                    count3++;
                }
            }
            if(count1 == len || count2 == len || count3 == len){
                list.add(str);
            }
        }
        
        String[] ans = new String[list.size()];
        int indx = 0;
        for(String str : list){
            ans[indx++] = str;
        }
        return ans;
    }
}
