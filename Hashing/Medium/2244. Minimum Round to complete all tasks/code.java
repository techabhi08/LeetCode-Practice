class Solution {
    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        Map<Integer, Integer> freq = new HashMap<>();
        for(int task : tasks){
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }
        
        int rounds = 0;
        
        for(int value : freq.values()){
            if(value == 1){
                return -1;
            }
            
            if(value % 3 == 0){
                rounds += value / 3;
            }
            //Suppose the value is 7 then 7 / 3 -> 2 but we 
            //will take 1 pair of 3 and 2 pair s of 2 hence (7 / 3) + 1
            //Will be same as else case so no need to add separately
            // else if(value % 3 == 1){
            //     rounds += value / 3 + 1;
            // }
            
            else{
                rounds += value / 3 + 1;
            }
        }
        return rounds;
    }
}
