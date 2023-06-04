class Solution {
    public int semiOrderedPermutation(int[] nums) {
        int ans = 0;
        if(nums[0] == 1 && nums[nums.length - 1] == nums.length){
            return 0;
        }
        int n = nums.length;
        
//         for(int i=0;i<n;i++){
//             if(nums[i] == 1){
//                 int j = i;
//                 while(j>0){
//                     numberOfOperations++;
//                     swap(nums, j, j-1);
//                     j--;
//                 }
//                 break;
//             }
//         }
        
//         for(int j=1;j<n;j++){
//             if(nums[j] == n){
//                 int k = j;
//                 while(k<n-1){
//                     numberOfOperations++;
//                     swap(nums, k, k+1);
//                     k++;
//                 }
//                 break;
//             }
//         }
        
        for(int i = 0; i < n; i++){
            if(nums[i] == 1){
                int one = i;
                
                while(one > 0){
                    ans++;
                    swap(one, one - 1, nums);
                    one--;
                }
                break;
            }
        }
        
        for(int j = 0; j < n; j++){
            if(nums[j] ==  n){
                int nPlace = j;
                
                while(nPlace < n - 1){
                    ans++;
                    swap(nPlace, nPlace + 1, nums);
                    nPlace++;
                }
                break;
            }
        }
        return ans;
    }
    
    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}