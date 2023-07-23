class Solution {
    public int maximumGood(int[][] statements) {
        int[] maxi = {0};
        findMax(statements, new boolean[statements.length], 0, 0, maxi);
        return maxi[0];
    }
    
    public void findMax(int[][] statements, boolean[] goodPeople, int currPerson, int currGood, int[] maxi){
        if(currPerson == goodPeople.length){
            maxi[0] = Math.max(maxi[0], currGood);
            return;
        }
        
        goodPeople[currPerson] = true;
        if(goodPeople.length - currPerson + currGood < maxi[0]){
            return;
        }
        if(isValid(statements, currPerson, goodPeople)){
            findMax(statements, goodPeople, currPerson + 1, currGood + 1, maxi);
        }
        
        goodPeople[currPerson] = false;
        if(goodPeople.length - currPerson - 1 + currGood < maxi[0]){
            return;
        }
        if(isValid(statements, currPerson, goodPeople)){
            findMax(statements, goodPeople, currPerson + 1, currGood, maxi);
        }
    }
    
    public boolean isValid(int[][] statements, int currPerson, boolean[] goodPeople){
        for(int i = 0; i < currPerson; i++){
            if(goodPeople[i]){
                if(goodPeople[currPerson] && statements[i][currPerson] == 0){
                    return false;
                }
                if(!goodPeople[currPerson] && statements[i][currPerson] == 1){
                    return false;
                }
            }
        }
        
        if(goodPeople[currPerson]){
            for(int i = 0; i < currPerson; i++){
                if(goodPeople[i] && statements[currPerson][i] == 0){
                    return false;
                }
                if(!goodPeople[i] && statements[currPerson][i] == 1){
                    return false;
                }
            }
        }
        return true;
    }
}