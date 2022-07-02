class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            list.add(i);
        }
        int index = 0;
        return countWinnerIndex(list, n, k, index);
    }
    
    public int countWinnerIndex(List<Integer> list, int n, int k, int index){
        if(list.size() == 1){
            return list.get(0);
        }
        
        index = (index + k - 1) % n;
        list.remove(index);
        return countWinnerIndex(list, n - 1, k, index);
    }
}
