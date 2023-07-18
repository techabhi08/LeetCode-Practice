class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        ans.add(intervals[0]);
        
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] > ans.get(ans.size() - 1)[1]){
                ans.add(intervals[i]);
            }else{
                int[] last = ans.get(ans.size() - 1);
                last[1] = Math.max(last[1], intervals[i][1]);
            }
        }
        
        int[][] res = new int[ans.size()][2];
        int i = 0;
        for(int[] item : ans){
            res[i++] = item;
        }
        return res;
    }
}