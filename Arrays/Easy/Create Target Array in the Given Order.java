class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        int[] target = new int[n];
        for(int i = 0; i < n; i++){
            list.add(index[i], nums[i]);
        }
        
        for(int i = 0; i < n; i++){
            target[i] = list.get(i);
        }
        return target;
    }
}
