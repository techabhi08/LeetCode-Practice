class Solution {
    int bobsMax = 0;
    int[] ans;
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        ans = new int[12];
        int[] bob = new int[12];
        findMax(aliceArrows, bob, numArrows, 11, 0);
        return ans;
    }
    
    public void findMax(int[] alice, int[] bob, int arrowsLeft, int index, int currPoints){
        if(index < 0){
            if(arrowsLeft > 0){
                bob[0] += arrowsLeft;
            }
            if(currPoints > bobsMax){
                bobsMax = currPoints;
                ans = (int[])bob.clone();
            }
            return;
        }
        
        if(arrowsLeft >= alice[index] + 1){
            bob[index] = alice[index] + 1;
            findMax(alice, bob, arrowsLeft - (alice[index] + 1), index - 1, currPoints + index);
            bob[index] = 0;
        }
        
        findMax(alice, bob, arrowsLeft, index - 1, currPoints);
        bob[index] = 0;
    }
}