class Pair {
    String word;
    int step;
    Pair(String word, int step){
        this.word = word;
        this.step = step;
    }
}

class Solution {
    public int minMutation(String start, String end, String[] bank) {
        char[] chars = {'A', 'C', 'G', 'T'};
        int n = bank.length;
        
        Set<String> set = new HashSet<>();
        for(String str : bank){
            set.add(str);
        }
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start, 0));
        
        if(set.contains(start)){
            set.remove(start);
        }
        
        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            String w = curr.word;
            int steps = curr.step;
            
            if(end.equals(w)){
                return steps;
            }
            
            for(int i = 0; i < w.length(); i++){
                for(char ch : chars){
                    char[] wordToReplaceArray = w.toCharArray();
                    wordToReplaceArray[i] = ch;
                    String newWord = new String(wordToReplaceArray);
                    
                    if(set.contains(newWord)){
                        set.remove(newWord);
                        queue.add(new Pair(newWord, steps + 1));
                    }
                }
            }
        }
        return -1;
    }
}
