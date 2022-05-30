class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
//         Arrays.sort(nums1);
//         Arrays.sort(nums2);
//         int[] intersection = new int[Math.min(nums1.length, nums2.length)];
//         int i = 0, n1 = 0, n2 = 0;
//         while(n1 < nums1.length && n2 < nums2.length){
//             while(n1 < nums1.length && nums1[n1] < nums2[n2]){
//                 n1++;
//             }
//             while(n1 < nums1.length && n2 < nums2.length && nums1[n1] > nums2[n2]){
//                 n2++;
//             }
//             if(n1 < nums1.length && n2 < nums2.length && nums1[n1] == nums2[n2]){
//                 intersection[i] = nums1[n1];
//                 i++;
//                 while(n1 < nums1.length && nums1[n1] == intersection[i - 1]){
//                     n1++;
//                 }
//                 while(n2 < nums2.length && nums2[n2] == intersection[i - 1]){
//                     n2++;
//                 }
//             }
            
//         }
//         int[] result = new int[i];
//         while(i - 1 >= 0){
//             result[i - 1] = intersection[i - 1];
//             i--;
//         }
//         return result;
        Set<Integer> arr= new HashSet<>();
        Set<Integer> result = new HashSet<>();
        
        for(int num : nums1){
            arr.add(num);
        }
        
        for(int num : nums2){
            if(arr.contains(num)){
                result.add(num);
            }
        }
        
        int i = 0;
        int[] ans = new int[result.size()];
        for(int num : result){
            ans[i] = num;
            i++;
        }
        return ans;
    }
}
