class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int p1 = 0;
        int p2 = 0;
        
        while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] < nums2[p2]){
                p1++;
            }
            else if(nums1[p1] > nums2[p2]){
                p2++;
            }else{
                result.add(nums1[p1]);
                p1++;
                p2++;
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
