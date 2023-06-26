class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        
        int i = 0;
        int j = costs.length - 1;
        
        long ans = 0;
        while(k-- > 0){
            while(pq1.size() < candidates && i <= j){
                pq1.add(costs[i++]);
            }
            while(pq2.size() < candidates && i <= j){
                pq2.add(costs[j--]);
            }
            
            int c1 = pq1.size() > 0 ? pq1.peek() : Integer.MAX_VALUE;
            int c2 = pq2.size() > 0 ? pq2.peek() : Integer.MAX_VALUE;
            
            if(c1 <= c2){
                ans += c1;
                pq1.poll();
            }else{
                ans += c2;
                pq2.poll();
            }
        }
        return ans;
    }
}