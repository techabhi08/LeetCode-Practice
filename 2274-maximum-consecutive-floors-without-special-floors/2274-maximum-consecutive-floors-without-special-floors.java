class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);

        int max = Math.max(special[0] - bottom, top - special[special.length - 1]);
        for(int i = 1; i < special.length; i++){
            max = Math.max(max, special[i] - special[i - 1] - 1);
        }
        return max;
    }
}