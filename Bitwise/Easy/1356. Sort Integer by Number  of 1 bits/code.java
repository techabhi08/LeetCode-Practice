class Solution {
    public int[] sortByBits(int[] arr) {
        int[] bits_count = new int[arr.length];
        int[] ans = new int[arr.length];
        Arrays.sort(arr);
        
        int i = 0;
        for(int num : arr){
            int count = countBits1(num);
            bits_count[i] = count;
            i++;
        }
        
        int j = 0;
        for(int k = 0; k < 14; k++){
            for(int m = 0; m < bits_count.length; m++){
                if(k == bits_count[m]){
                    ans[j++] = arr[m];
                }
            }
        }
        return ans;
    }
    
    public int countBits1(int n){
        int count = 0;
        while(n > 0){
            if((n & 1) == 1){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}
