class Solution {
    public int findKthLargest(int[] nums, int k) {
        // insertionSort(nums);
        // return nums[k - 1];
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        return nums[nums.length - k];
    }
    
    public void quickSort(int[] nums, int lo, int hi){
        if(lo >= hi){
            return;
        }
        
        int s = lo;
        int e = hi;
        int mid = s + (e - s)/2;
        int pivot = nums[mid];
        while(s <= e){
            while(nums[s] < pivot){
                s++;
            }
            while(nums[e] > pivot){
                e--;
            }
            if(s <= e){
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }
        quickSort(nums, lo, e);
        quickSort(nums, s, hi);
    }
    
    // public void insertionSort(int[] arr){
    //     for(int i = 0; i < arr.length - 1; i++){
    //         for(int j = i + 1; j > 0; j--){
    //             if(arr[j] > arr[j - 1]){
    //                 int temp = arr[j];
    //                 arr[j] = arr[j - 1];
    //                 arr[j - 1] = temp;
    //             }else{
    //                 break;
    //             }
    //         }
    //     }
    // }
}
