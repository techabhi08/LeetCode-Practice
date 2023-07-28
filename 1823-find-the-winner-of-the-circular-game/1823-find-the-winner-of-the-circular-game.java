class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            list.add(i);
        }
        return find(0, n, list, k);
    }
    
    public int find(int index, int n, List<Integer> list, int k){
        if(list.size() == 1){
            return list.get(0);
        }
        
        index = (index + k - 1) % n;
        list.remove(index);
        return find(index, n - 1, list, k);
    }
}