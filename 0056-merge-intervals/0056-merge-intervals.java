class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        int index = 0;
        
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        
        while(index < intervals.length){
            if(ans.size() == 0 || ans.get(ans.size() - 1)[1] < intervals[index][0]){
                ans.add(new int[]{intervals[index][0], intervals[index][1]});
            }else{
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], intervals[index][1]);
            }
            index++;
        }
        
        int[][] arr = new int[ans.size()][2];
        int i = 0;
        for(int[] interval : ans){
            arr[i++] = interval;
        }
        return arr;
    }
}