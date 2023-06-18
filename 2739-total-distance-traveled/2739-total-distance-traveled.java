class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int ans = 0;
        if(mainTank < 5){
            return mainTank * 10;
        }
        else{
            while(mainTank > 0){
                if(mainTank >= 5){
                    mainTank -= 5;
                    ans += 50;
                    
                    if(additionalTank >= 1){
                        additionalTank--;
                        mainTank++;
                    }
                }else{
                    ans += mainTank * 10;
                    mainTank = 0;
                }
            }
        }
        
        return ans;
    }
}