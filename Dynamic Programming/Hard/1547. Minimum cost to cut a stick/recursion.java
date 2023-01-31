class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        Arrays.sort(cuts);
        int[] arr = new int[m + 2];
        arr[0] = 0;
        arr[m + 1] = n;
        int i = 1;
        for(int num : cuts){
            arr[i++] = num;
        }
        
        return findCost(1, m, arr);
    }
    
    public int findCost(int i, int j, int[] arr){
        if(i > j){
            return 0;
        }
        
        int min = (int)1e8;
        for(int k = i; k <= j; k++){
            int cost = arr[j + 1] - arr[i - 1] + findCost(i, k - 1, arr) + findCost(k + 1, j, arr);
            min = Math.min(min, cost);
        }
        return min;
    }
}
