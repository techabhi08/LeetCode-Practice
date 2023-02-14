class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        
        int n = candyType.length;
        int eatsAllowed = n / 2;
        
        for(int num : candyType){
            set.add(num);
        }
        
        return Math.min(eatsAllowed, set.size());
    }
}
