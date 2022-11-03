class Solution {
    public String reformat(String s) {
        List<Character> chars = new ArrayList<>();
        List<Character> digits = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                digits.add(s.charAt(i));
            }else{
                chars.add(s.charAt(i));
            }
        }
        
        if(Math.abs(chars.size() - digits.size()) > 1){
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        if(chars.size() > digits.size()){
            for(int i = 0; i < chars.size(); i++){
                sb.append(chars.get(i));
                
                if(i < digits.size()){
                    sb.append(digits.get(i));
                }
            }
        }else{
            for(int i = 0; i < digits.size(); i++){
                sb.append(digits.get(i));
                
                if(i < chars.size()){
                    sb.append(chars.get(i));
                }
            }
        }
        return sb.toString();
    }
}
