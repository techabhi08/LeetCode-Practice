class Solution {
    public int countOdds(int low, int high) {
        int count = (low % 2 != 0 || high % 2 != 0) ? 1 : 0;
        count += ((high - low) / 2 );
        return count;
    }
}
