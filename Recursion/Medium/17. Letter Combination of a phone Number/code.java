class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            ArrayList<String> nullList = new ArrayList<>();
            return nullList;
        }
         return returnPhoneNum("", digits);
    }
    
    public ArrayList<String> returnPhoneNum(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0';
        ArrayList<String> ans = new ArrayList<>();

        if(digit == 7){
            for(int i = (digit - 2) * 3; i <= (digit - 1) * 3; i++){
                char ch = (char) ('a' + i);
                ans.addAll(returnPhoneNum(p + ch, up.substring(1)));
            }
        }else if(digit == 8){
            for(int i = (digit - 2) * 3 + 1; i <= (digit - 1) * 3; i++){
                char ch = (char) ('a' + i);
                ans.addAll(returnPhoneNum(p + ch, up.substring(1)));
            }
        }else if(digit == 9){
            for(int i = (digit - 2) * 3 + 1; i <= (digit - 1) * 3 + 1; i++){
                char ch = (char) ('a' + i);
                ans.addAll(returnPhoneNum(p + ch, up.substring(1)));
            }
        }else{
            for(int i = (digit - 2) * 3; i < (digit - 1) * 3; i++){
                char ch = (char) ('a' + i);
                ans.addAll(returnPhoneNum(p + ch, up.substring(1)));
            }
        }
        return ans;
    }
}
