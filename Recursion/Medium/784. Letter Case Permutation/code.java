class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        findPermutation(s.toCharArray(), 0, result);
        return result;
    }
    
    public void findPermutation(char[] str, int index, List<String> result){
        if(index == str.length){
            result.add(new String(str));
            return;
        }
        
        if(Character.isLetter(str[index])){
            if (Character.isUpperCase(str[index])) {
                str[index] = Character.toLowerCase(str[index]);
                findPermutation(str, index + 1, result);
                
                str[index] = Character.toUpperCase(str[index]);
            }
            else {
                str[index] = Character.toUpperCase(str[index]);
                findPermutation(str, index + 1, result);
                str[index] = Character.toLowerCase(str[index]);
            }
        }
        findPermutation(str, index + 1,  result);
    }
}
