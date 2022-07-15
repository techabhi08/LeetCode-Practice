class Twitter {
    class Node{
        int userId;
        int tweetId;
        Node next;
        
        Node(){}
        
        Node(int userId, int tweetId){
            this.userId = userId;
            this.tweetId = tweetId;
        }
        
        Node(int userId, int tweetId, Node next){
            this.userId = userId;
            this.tweetId = tweetId;
            this.next = next;
        }
    }
    
    HashMap<Integer, HashSet<Integer>> connections;
    
    Node head;
    
    public Twitter() {
        connections = new HashMap<>();
        head = new Node(0,0);
    }
    
    public void postTweet(int userId, int tweetId) {
        insert(new Node(userId, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        connections.putIfAbsent(userId, new HashSet<>());
        
        List<Integer> list = new ArrayList<>();
        
        Node curr = head.next;
        
        while(curr != null && list.size() < 10){
            if(connections.get(userId).contains(curr.userId) || userId == curr.userId)
                list.add(curr.tweetId);
            
            curr = curr.next;
        }
        
        return list;
        
    }
    
   public void follow(int followerId, int followeeId) {
        connections.putIfAbsent(followerId, new HashSet<>());
        
        connections.get(followerId).add(followeeId);
    }
    
    
    public void unfollow(int followerId, int followeeId) {
        connections.putIfAbsent(followerId, new HashSet<>());
        
        if(connections.get(followerId).contains(followeeId))
            connections.get(followerId).remove(followeeId);
    }
    
    public void insert(Node node){
        node.next = head.next;
        head.next = node;
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
