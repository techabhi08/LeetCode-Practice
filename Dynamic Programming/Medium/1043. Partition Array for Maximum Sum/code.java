class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        return findMaxSum(0, k, arr);
    }
    
    public int findMaxSum(int index, int k, int[] arr){
        if(index == arr.length){
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        int result = 0;
        for(int j = index; j < Math.min(arr.length, index + k); j++){
            max = Math.max(max, arr[j]);
            int sum = (j - index + 1) * max + findMaxSum(j + 1, k, arr);
            result = Math.max(result, sum);
        }
        
        return result;
    }
}
