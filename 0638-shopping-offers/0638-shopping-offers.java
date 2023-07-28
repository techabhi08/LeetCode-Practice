class Solution {
    int ans;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        ans = buyDirectly(price, needs);
        findOffers(price, needs, special, 0, 0);
        return ans;
    }
    
    public int buyDirectly(List<Integer> price, List<Integer> needs){
        int total = 0;
        int n = needs.size();
        for(int i = 0; i < n; i++){
            total += price.get(i) * needs.get(i);
        }
        return total;
    }
    
    public void findOffers(List<Integer> price, List<Integer> needs, List<List<Integer>> special, int currPrice, int index){
        if(currPrice >= ans){
            return;
        }
        if(index == special.size()){
            currPrice += buyDirectly(price, needs);
            if(currPrice < ans){
                ans = currPrice;
            }
            return;
        }
        
        List<Integer> offer = special.get(index);
        if(canBuy(needs, offer)){
            int n = needs.size();
            List<Integer> updatedNeeds = new ArrayList<>();
            for(int i = 0; i < n; i++){
                updatedNeeds.add(needs.get(i) - offer.get(i));
            }
            findOffers(price, updatedNeeds, special, currPrice + offer.get(n), index);
        }
        findOffers(price, needs, special, currPrice, index + 1);
    }
    
    public boolean canBuy(List<Integer> needs, List<Integer> offers){
        int n = needs.size();
        for(int i = 0; i < n; i++){
            if(needs.get(i) < offers.get(i)){
                return false;
            }
        }
        return true;
    }
}