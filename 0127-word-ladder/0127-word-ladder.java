class Pair{
    String word;
    int steps;
    
    Pair(String word, int steps){
        this.word = word;
        this.steps = steps;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>();
        for(String word : wordList){
            words.add(word);
        }
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        
        if(words.contains(beginWord)){
            words.remove(beginWord);
        }
        
        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            String word = curr.word;
            int steps = curr.steps;
            
            if(word.equals(endWord)){
                return steps;
            }
            
            for(int i = 0; i < word.length(); i++){
                for(char c = 'a'; c <= 'z'; c++){
                    char[] wordToReplace = word.toCharArray();
                    wordToReplace[i] = c;
                    String newWord = new String(wordToReplace);
                    
                    if(words.contains(newWord)){
                        words.remove(newWord);
                        queue.add(new Pair(newWord, steps + 1));
                    }
                }
            }
        }
        
        return 0;
    }
}