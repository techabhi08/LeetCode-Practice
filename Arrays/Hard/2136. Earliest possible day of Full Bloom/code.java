class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            arr[i][0] = plantTime[i];
            arr[i][1] = growTime[i];
        }
        
        Arrays.sort(arr, (a, b) -> (b[1] - a[1]));
        int max = 0;
        int sum = 0;
        for(int[] day : arr){
            int plant = day[0];
            int grow = day[1];
            max = Math.max(max, sum + plant + grow);
            sum += plant;
        }
        return max;
    }
}
