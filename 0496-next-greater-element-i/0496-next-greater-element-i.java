class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums2){
            while(!stack.isEmpty() && stack.peek() < num){
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        
        int i = 0;
        for(int num : nums1){
            if(map.containsKey(num)){
                ans[i++] = map.get(num);
            }else{
                ans[i++] = -1;
            }
        }
        return ans;
    }
}