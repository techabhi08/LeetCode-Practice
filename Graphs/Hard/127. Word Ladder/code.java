class Pair {
    String first;
    int second;
    
    Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        Set<String> set = new HashSet<>();
        int len = wordList.size();
        
        for(int i = 0; i < len; i++){
            set.add(wordList.get(i));
        }
        set.remove(beginWord);
        
        while(!queue.isEmpty()){
            String word = queue.peek().first;
            int step = queue.peek().second;
            queue.remove();
            if(word.equals(endWord)){
                return step;
            }
            
            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] replacedWordArray = word.toCharArray();
                    replacedWordArray[i] = ch;
                    String replacedWord = new String(replacedWordArray);
                    
                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        queue.add(new Pair(replacedWord, step + 1));
                    }
                }
            }
        }
        return 0;
    }
}
