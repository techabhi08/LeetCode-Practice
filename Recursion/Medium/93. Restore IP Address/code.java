class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        findPaths(0 , s, "", 0, ans);
        return ans;
    }
    
    public void findPaths(int index, String s, String path, int dots, List<String> ans){
        if(dots == 4 && index >= s.length()){
            ans.add(path.substring(0, path.length() - 1));
            return;
        }
        if(dots > 4){
            return;
        }
        
        for(int i = 1; i <= 3 && index + i <= s.length(); i++){
            String curr = s.substring(index, index + i);
            if(curr.charAt(0) == '0' && i != 1){
                break;
            }else{
                if(Integer.parseInt(curr) <= 255){
                    findPaths(index + i, s, path + s.substring(index, index + i) + ".", dots + 1, ans);
                }
            }
        }
    }
}
