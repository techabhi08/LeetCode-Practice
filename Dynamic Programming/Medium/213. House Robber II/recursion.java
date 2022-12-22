class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] arr1 = new int[nums.length - 1];
        int[] arr2 = new int[nums.length - 1];
        int idx1 = 0;
        int idx2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(i != 0){
                arr1[idx1++] = nums[i];
            }
            if(i != nums.length - 1){
                arr2[idx2++] = nums[i];
            }
        }
        
        int first = findProfit(arr1, arr1.length - 1);
        int last = findProfit(arr2, arr2.length - 1);
        return Math.max(first, last);
    }
    
    public int findProfit(int[] arr, int index){
        if(index == 0){
            return arr[index];
        }
        
        if(index < 0){
            return 0;
        }
        
        int pick = arr[index] + findProfit(arr, index - 2);
        int notPick = 0 + findProfit(arr, index - 1);
        
        return Math.max(pick, notPick);
        
    }
}
