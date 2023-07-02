class Solution {
    int res = 0;
    public int maximumRequests(int n, int[][] requests) {
        int[] ans = new int[n];
        findMax(0, 0, requests, n, ans);
        return res;
    }
    
    public void findMax(int index, int count, int[][] requests, int n, int[] ans){
        if(index == requests.length){
            for(int i = 0; i < ans.length; i++){
                if(ans[i] != 0){
                    return;
                }
            }
            
            res = Math.max(res, count);
            return;
        }
        
        ans[requests[index][0]]--;
        ans[requests[index][1]]++;
        
        findMax(index + 1, count + 1, requests, n, ans);
        
        ans[requests[index][0]]++;
        ans[requests[index][1]]--;
        
        findMax(index + 1, count, requests, n, ans);
    }
}