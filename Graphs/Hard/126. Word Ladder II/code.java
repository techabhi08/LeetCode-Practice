class Solution {
    String b;
    HashMap<String, Integer> mpp;
    List<List<String>> ans;
    
    private void dfs(String word, List<String> seq){
        if(word.equals(b)){
            List<String> dup = new ArrayList<>(seq);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }
        
        int steps = mpp.get(word);
        int sz = word.length();
        
        for(int i = 0; i < sz; i++){
            for(char ch = 'a'; ch <= 'z'; ch++){
                char[] replacedCharArray = word.toCharArray();
                replacedCharArray[i] = ch;
                String replacedWord = new String(replacedCharArray);
                
                if(mpp.containsKey(replacedWord) && mpp.get(replacedWord) + 1 == steps){
                    seq.add(replacedWord);
                    dfs(replacedWord, seq);
                    seq.remove(seq.size() - 1);
                }
            }
        }
    }
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        int len = wordList.size();
        
        for(int i = 0; i < len; i++){
            set.add(wordList.get(i));
        }
        
        Queue<String> queue = new LinkedList<>();
        b = beginWord;
        queue.add(beginWord);
        
        mpp = new HashMap<>();
        mpp.put(beginWord, 1);
        int sizee = beginWord.length();
        
        set.remove(beginWord);
        
        while(!queue.isEmpty()){
            String word = queue.peek();
            int steps = mpp.get(word);
            queue.remove();
            
            if(word.equals(endWord)){
                break;
            }
            for(int i = 0; i < sizee; i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    
                    if(set.contains(replacedWord)){
                        queue.add(replacedWord);
                        set.remove(replacedWord);
                        mpp.put(replacedWord, steps + 1);
                    }
                }
            }
        }
        
        ans = new ArrayList<>();
        if(mpp.containsKey(endWord)){
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord, seq);
        }
        return ans;
    }
}
