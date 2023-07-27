class Pair{
    String word;
    int steps;
    
    Pair(String word, int steps){
        this.word = word;
        this.steps = steps;
    }
}
class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> set = new HashSet<>();
        for(String word : bank){
            set.add(word);
        }
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startGene, 0));
        if(set.contains(startGene)){
            set.remove(startGene);
        }
        
        int count = 0;
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            String curr = pair.word;
            int steps = pair.steps;
            
            if(curr.equals(endGene)){
                return steps;
            }
            
            char[] genes = {'A', 'C', 'G', 'T'};
            for(int i = 0; i < curr.length(); i++){
                for(char ch : genes){
                    char[] charToReplace = curr.toCharArray();
                    charToReplace[i] = ch;
                    String newWord = new String(charToReplace);
                    if(set.contains(newWord)){
                        queue.add(new Pair(newWord, steps + 1));
                        set.remove(newWord);
                    }
                }
            }
        }
        return -1;
    }
}