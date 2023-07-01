class Solution {
    int ans;
    public int distributeCookies(int[] cookies, int k) {
        ans = Integer.MAX_VALUE;
        int[] arr = new int[k];
        findDfs(0, cookies, k, arr);
        return ans;
    }
    
    public void findDfs(int index, int[] cookies, int k, int[] arr){
        if(index == cookies.length){
            int max = 0;
            for(int num : arr){
                max = Math.max(max, num);
            }
            ans = Math.min(ans, max);
            return;
        }
        
        for(int i = 0; i < k; i++){
            arr[i] += cookies[index];
            findDfs(index + 1, cookies, k, arr);
            arr[i] -= cookies[index];
        }
    }
}