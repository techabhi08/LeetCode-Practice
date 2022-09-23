class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int idx1 = 0;
        int idx2 = 0;
        int prev = 0;
        int curr = 0;
        for(int i = 0; i <= len / 2; i++){
            prev = curr;
            if(idx1 == nums1.length){
                curr = nums2[idx2++];
            }else if(idx2 == nums2.length){
                curr = nums1[idx1++];
            }else if(nums1[idx1] < nums2[idx2]){
                curr = nums1[idx1++];
            }else{
                curr = nums2[idx2++];
            }
        }
        
        if(len % 2 == 0){
            return (float)(prev + curr )/ 2;
        }
        return curr;
    }
}
