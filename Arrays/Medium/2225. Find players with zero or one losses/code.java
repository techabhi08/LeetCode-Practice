class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> result = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        Set<Integer> zeroLoss = new HashSet<>();
        Set<Integer> oneLoss = new HashSet<>();
        Set<Integer> nLoss = new HashSet<>();
        
        for(int[] match : matches){
            int win = match[0];
            int loss = match[1];
            
            //Adding winner
            if(!oneLoss.contains(win) && !nLoss.contains(win)){
                zeroLoss.add(win);
            }
            //Adding looser
            if(zeroLoss.contains(loss)){
                zeroLoss.remove(loss);
                oneLoss.add(loss);
            }else if(oneLoss.contains(loss)){
                oneLoss.remove(loss);
                nLoss.add(loss);
            }else if(nLoss.contains(loss)){
                continue;
            }else{
                oneLoss.add(loss);
            }
        }
        
        result.get(0).addAll(zeroLoss);
        result.get(1).addAll(oneLoss);
        Collections.sort(result.get(0));
        Collections.sort(result.get(1));
        
        return result;
    }
}
