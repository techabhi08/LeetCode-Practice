class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if(numRows == 0){
            return list;
        }
        
        for(int i = 0; i < numRows; i++){
            List<Integer> inner = new ArrayList<>();
            for(int j = 0; j < i + 1; j++){
                if(j == 0 || j == i){
                    inner.add(1);
                }else{
                    inner.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                }
            }
            list.add(inner);
        }
        return list;
    }
}
