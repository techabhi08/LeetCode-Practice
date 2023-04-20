class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasInTank = 0;
        for(int i = 0; i < gas.length; i++){
            gasInTank += gas[i] - cost[i];
        }
        if(gasInTank < 0){
            return -1;
        }
        
        int currStart = 0;
        int fuelLeft = 0;
        for(int i = 0; i < gas.length; i++){
            int currFuel = gas[i] - cost[i];
            
            if(fuelLeft + currFuel < 0){
                currStart = i + 1;
                fuelLeft = 0;
            }else{
                fuelLeft += currFuel;
            }
        }
        return currStart;
    }
}
