class Stock{
    int timestamp;
    int price;
    
    Stock(){}
    
    Stock(int timestamp, int price){
        this.timestamp = timestamp;
        this.price = price;
    }
}

class StockPrice {
    Map<Integer, Integer> map = new HashMap<>();
    PriorityQueue<Stock> min = new PriorityQueue<>((a, b) -> a.price - b.price);
    PriorityQueue<Stock> max = new PriorityQueue<>((a, b) -> b.price - a.price);
    Stock currStock;
    
    public StockPrice() {
        currStock = new Stock();
    }
    
    public void update(int timestamp, int price) {
        if(timestamp >= currStock.timestamp){
            currStock.timestamp = timestamp;
            currStock.price = price;
        }
        Stock stock = new Stock(timestamp, price);
        map.put(timestamp, price);
        min.add(stock);
        max.add(stock);
    }
    
    public int current() {
        return currStock.price;
    }
    
    public int maximum() {
        Stock curr;
        while(true){
            curr = max.peek();
            if(curr.price != map.get(curr.timestamp)){
                max.poll();
            }else{
                break;
            }
        }
        return curr.price;
    }
    
    public int minimum() {
        Stock curr;
        while(true){
            curr = min.peek();
            if(curr.price != map.get(curr.timestamp)){
                min.poll();
            }else{
                break;
            }
        }
        return curr.price;
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */