class Solution {
    public int minCostToMoveChips(int[] position) {
        int evenPos = 0;
        for(int i = 0 ; i < position.length; i++){
            if(position[i] % 2 == 0){
                evenPos++;
            }
        }
        return Math.min(evenPos, position.length - evenPos);
    }
}
