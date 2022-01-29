class Solution {
    public String freqAlphabets(String s) {
        String str = "";
        for(int i = 0; i < s.length(); i++){
            if(i < s.length() -2 && s.charAt(i + 2) == '#'){
                String value = s.charAt(i)+""+s.charAt(i+1);
                str += (char)(Integer.parseInt(value) + 96);
                i += 2;
            }else{
                str += (char)(Integer.parseInt(s.charAt(i) +"") + 96);
            }
        }
        return str;
    }
}
