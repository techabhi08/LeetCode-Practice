class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        int index = 0;
        
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        
        for(int i = 0; i < intervals.length; i++){
            if(ans.size() == 0 || (ans.get(ans.size() - 1)[1] < intervals[i][0])){
                ans.add(new int[]{intervals[i][0], intervals[i][1]});
            }else{
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], intervals[i][1]);
            }
        }
        
        int[][] arr = new int[ans.size()][2];
        int i = 0;
        for(int[] interval : ans){
            arr[i++] = interval;
        }
        return arr;
    }
}
