class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < numRows; i++){
            List<Integer> inner = new ArrayList<>();
            for(int j = 0; j < i + 1; j++){
                if(j == 0 || j == i){
                    inner.add(1);
                }else{
                    List<Integer> prev = ans.get(ans.size() - 1);
                    inner.add(prev.get(j - 1) + prev.get(j));
                }
            }
            ans.add(inner);
        }
        return ans;
    }
}