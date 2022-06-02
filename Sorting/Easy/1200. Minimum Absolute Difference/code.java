class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        
        int minimum = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length - 1; i++){
            minimum = Math.min(minimum, (arr[i + 1] - arr[i]));
        }
        
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i+ 1] - arr[i] == minimum){
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[i+1]);
                result.add(pair);
            }
        }
        return result;
    }
}
