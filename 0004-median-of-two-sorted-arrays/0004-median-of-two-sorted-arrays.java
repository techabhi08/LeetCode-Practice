class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int ind1 = 0;
        int ind2 = 0;
        int prev = 0, curr = 0;
        
        for(int i = 0; i <= len / 2; i++){
            prev = curr;
            if(ind1 == nums1.length){
                curr = nums2[ind2++];
            }else if(ind2 == nums2.length){
                curr = nums1[ind1++];
            }else if(nums1[ind1] < nums2[ind2]){
                curr = nums1[ind1++];
            }else{
                curr = nums2[ind2++];
            }
        }
        
        if(len % 2 == 0){
            return (double)(prev + curr )/ 2;
        }
        return curr;
    }
}