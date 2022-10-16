class Solution {
    private class Engineer{
        int speed;
        int effeciency;
        Engineer(int speed, int effeciency){
            this.speed = speed;
            this.effeciency = effeciency;
        }
    }
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<Engineer> engineers = new ArrayList<>();
        for(int i = 0; i < n; i++){
            engineers.add(new Engineer(speed[i], efficiency[i]));
        }
        engineers.sort((a,b) -> b.effeciency - a.effeciency);
        
        PriorityQueue<Engineer> queue = new PriorityQueue<Engineer>((a, b) -> a.speed - b.speed);
        long maxPerform = 0;
        long totalSpeed = 0;
        long perform;
        
		for (Engineer engineer: engineers) {
            if (queue.size() == k) {
                totalSpeed -= queue.peek().speed;
                queue.poll();
            } 
            totalSpeed += engineer.speed;
            perform = totalSpeed * (long) engineer.effeciency;
            queue.add(engineer);
            maxPerform = Math.max(maxPerform, perform);
        }
        return (int)(maxPerform % (1000000007));
    }
}
