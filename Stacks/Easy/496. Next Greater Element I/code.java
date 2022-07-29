class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        //Finding those number that have a greater number present for them, next to them in the nums2.
        for(int num : nums2){
            while(!stack.empty() && stack.peek() < num){
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        
        int[] ans = new int[nums1.length];
        int i = 0;
        
        for(int num : nums1){
            if(map.get(num) != null){
                ans[i++] = map.get(num);
            }else{
                ans[i++] = -1;
            }
        }
        return ans;
    }
}
