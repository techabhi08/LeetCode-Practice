class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        return findAns("", digits);
    }
    
    public List<String> findAns(String str, String digits){
        if(digits.isEmpty()){
            List<String> ans = new ArrayList<>();
            ans.add(str);
            return ans;
        }
        
        int digit = digits.charAt(0) - '0';
        List<String> list = new ArrayList<>();
        
        if(digit == 7){
            for(int i = (digit - 2) * 3; i <= (digit - 1) * 3; i++){
                char ch = (char)(i + 'a');
                list.addAll(findAns(str + ch, digits.substring(1)));
            }
        }
        else if(digit == 8){
            for(int i = (digit - 2) * 3 + 1; i <= (digit - 1) * 3; i++){
                char ch = (char)(i + 'a');
                list.addAll(findAns(str + ch, digits.substring(1)));
            }
        }
        else if(digit == 9){
            for(int i = (digit - 2) * 3 + 1; i <= (digit - 1) * 3 + 1; i++){
                char ch = (char)(i + 'a');
                list.addAll(findAns(str + ch, digits.substring(1)));
            }
        }else{
            for(int i = (digit - 2) * 3; i < (digit - 1) * 3; i++){
                char ch = (char)(i + 'a');
                list.addAll(findAns(str + ch, digits.substring(1)));
            }
        }
        return list;
    }
}