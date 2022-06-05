class Solution {
    public int[] sortByBits(int[] arr) {
        int[] ans = new int[arr.length];
        int[] bits = new int[arr.length];
        int i = 0;
        Arrays.sort(arr);
        
        for(int num : arr){
            int count_one = findBinaryOnes(num);
            bits[i++] = count_one;
        }
        
        //less than 14 is taken because the constraint is less than 10^4.
        //max number can be 10000. In binary if we take 14 one's we get 16383.
        int t = 0;
        for(int j = 0; j < 14; j++){
            for(int k = 0; k < bits.length; k++){
                if(j == bits[k]){
                    ans[t++] = arr[k];
                }
            }
        }
        return ans;
    }
    
    public int findBinaryOnes(int n){
        int count = 0;
        while(n != 0){
            int rem = n % 2;
            if(rem == 1){
                count++;
            }
            n /= 2;
        }
        return count;
    }
}
