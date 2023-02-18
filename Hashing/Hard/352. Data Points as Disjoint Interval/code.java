class SummaryRanges {
    Set<Integer> values;
    
    public SummaryRanges() {
        values = new TreeSet<>();
    }
    
    public void addNum(int value) {
        values.add(value);
    }
    
    public int[][] getIntervals() {
        if(values.isEmpty()){
            return new int[0][2];
        }
        
        List<int[]> intervals = new ArrayList<>();
        int left = -1, right = -1;
        
        for(int value: values){
            if(left < 0){
                //This means we are on first value of set.
                left = value;
                right = value;
            }else if(value - right == 1){
                //The current value can be joined to the same inteval.
                right = value;
            }else{
                //adding the current inteval to intervals, bczo the current value is
                //disjoint from current interval, hence we will create new interval for the
                //same.
                intervals.add(new int[] {left, right});
                left = value;
                right = value;
            }
        }
        intervals.add(new int[]{left, right});
        return intervals.toArray(new int[0][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */
