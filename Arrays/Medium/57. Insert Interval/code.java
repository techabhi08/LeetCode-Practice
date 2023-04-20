class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int index = 0;
        
        while(index < intervals.length){
            if(intervals[index][0] < newInterval[0]){
                ans.add(intervals[index]);
                index++;
            }else{
                break;
            }
        }
        
        if(ans.size() == 0 || (ans.get(ans.size() - 1)[1] < newInterval[0])){
            ans.add(newInterval);
        }else{
            int[] lastInterval = ans.get(ans.size() - 1);
            lastInterval[1] = Math.max(lastInterval[1], newInterval[1]);
        }
        
        while(index < intervals.length){
            int[] last = ans.get(ans.size() - 1);
            if(last[1] >= intervals[index][0]){
                last[1] = Math.max(last[1], intervals[index][1]);
                index++;
            }else{
                ans.add(intervals[index]);
            }
        }
        
        int[][] res = new int[ans.size()][2];
        int i = 0;
        for(int[] interval : ans){
            res[i++] = interval;
        }
        return res;
    }
}
