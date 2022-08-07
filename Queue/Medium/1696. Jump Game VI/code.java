class Solution {
    public int maxResult(int[] nums, int k) {
        int[] score = new int[nums.length];
        LinkedList<Integer> queue = new LinkedList<>();
        
        score[0] = nums[0];
        queue.offer(0);
        
        for(int i = 1; i < nums.length; i++){
            if(queue.getFirst() < i - k){
                queue.removeFirst();
            }
            score[i] = score[queue.getFirst()] + nums[i];
            
            while(!queue.isEmpty() && score[queue.getLast()] <= score[i]){
                queue.removeLast();
            }
            queue.addLast(i);
        }
        return score[nums.length - 1];
    }
}
