class Pair {
    String word;
    int steps;
    Pair(String word, int steps){
        this.word = word;
        this.steps = steps;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String word : wordList){
            set.add(word);
        }
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        
        if(set.contains(beginWord)){
            set.remove(beginWord);
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
                    if(set.contains(newWord)){
                        set.remove(newWord);
                        queue.add(new Pair(newWord, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}