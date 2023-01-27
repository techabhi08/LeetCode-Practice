class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> arr = new ArrayList<>();
        arr.add(nums[0]);
        
        for(int i = 1; i < n; i++){
            if(nums[i] > arr.get(arr.size() - 1)){
                arr.add(nums[i]);
            }else{
                int start = 0;
                int end = arr.size() - 1;
                
                while(start < end){
                    int mid = start + (end - start) / 2;
                    if(arr.get(mid) == nums[i]){
                        end = mid;
                        break;
                    }else if(arr.get(mid) < nums[i]){
                        start = mid + 1;
                    }else{
                        end = mid;
                    }
                }
                arr.set(end, nums[i]);
            }
        }
        return arr.size();
    }
}
