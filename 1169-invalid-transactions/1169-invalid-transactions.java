class Transaction {
    String name;
    int time;
    int amount;
    String city;
    
    Transaction(String str){
        String[] t = str.split(",");
        this.name = t[0];
        this.time = Integer.parseInt(t[1]);
        this.amount = Integer.parseInt(t[2]);
        this.city = t[3];
    }
}

class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> ans = new ArrayList<>();
        
        Map<String, List<Transaction>> map = new HashMap<>();
        
        for(String entry : transactions){
            Transaction t = new Transaction(entry);
            if(!map.containsKey(t.name)){
                map.put(t.name, new ArrayList<>());
            }
            map.get(t.name).add(t);
        }
        
        for(String entry : transactions){
            Transaction t = new Transaction(entry);
            
            if(invalid(t, map.getOrDefault(t.name, new ArrayList<>()))){
                ans.add(entry);
            }
        }
        return ans;
    }
    
    public boolean invalid(Transaction t, List<Transaction> list){
        if(t.amount > 1000){
            return true;
        }
        
        for(Transaction trans : list){
            if(Math.abs(trans.time - t.time) <= 60 && !t.city.equals(trans.city)){
                return true;
            }
        }
        return false;
    }
}