class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for(int num : asteroids){
            if(num > 0){
                stack.push(num);
            }else{
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(num)){
                    stack.pop();
                }
                if(stack.isEmpty() || stack.peek() < 0){
                    stack.push(num);
                }
                if(stack.peek() == Math.abs(num)){
                    stack.pop();
                }
            }
        }
        
        int[] ans = new int[stack.size()];
        int j = stack.size() - 1;
        while(!stack.isEmpty()){
            ans[j--] = stack.pop();
        }
        return ans;
    }
}
