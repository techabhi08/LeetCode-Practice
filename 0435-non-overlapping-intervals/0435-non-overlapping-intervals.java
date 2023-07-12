class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        int prev = intervals[0][1];
        int count = 0;
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < prev){
                prev = Math.min(intervals[i][1], prev);
                count++;
            }else{
                prev = intervals[i][1];
            }
        }
        
        return count;
    }
}