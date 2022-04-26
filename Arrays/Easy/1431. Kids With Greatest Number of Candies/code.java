class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int n = candies.length;
        int max = 0;
        for(int i = 0; i < n; i++){
            if(candies[i] > max)
                max = candies[i];
        }
        
        for(int j = 0; j < n; j++){
            if(candies[j] + extraCandies >= max){
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}
