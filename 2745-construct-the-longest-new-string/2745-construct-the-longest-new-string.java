class Solution {
    public int longestString(int x, int y, int z) {
        return 2 * (2 * Math.min(x, y) + z + (x != y ? 1 : 0));
    }
}