class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > temp.get(temp.size() - 1)){
                temp.add(nums[i]);
            }else{
                int index = findIndex(0, temp.size() - 1, nums[i], temp);
                temp.set(index, nums[i]);
            }
        }
        return temp.size();
    }
    
    public int findIndex(int start, int end, int target, List<Integer> temp){
        while(start < end){
            int mid = start + (end - start) / 2;
            if(temp.get(mid) == target){
                return mid;
            }else if(temp.get(mid) <= target){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return end;
    }
}