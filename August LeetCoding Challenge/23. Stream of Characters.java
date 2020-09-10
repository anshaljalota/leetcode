/*

Implement the StreamChecker class as follows:

StreamChecker(words): Constructor, init the data structure with the given words.
query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to newest, including this letter just queried) spell one of the words in the given list.
*/

class StreamChecker {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            this.isEnd = false;
            this.children = new TrieNode[26];
        }
    }
    List<Character> li;
    TrieNode root;
    int max_len;
    public StreamChecker(String[] words) {
        li = new ArrayList<>();
        root = new TrieNode();
        max_len=0;
        for(String word: words){
            if(word.length()>max_len)
                max_len = word.length();
            TrieNode curr = root;
            for(int i=word.length()-1;i>=0;i--){
                char c = word.charAt(i);
                if(curr.children[c-'a']==null){
                    curr.children[c-'a'] = new TrieNode();
                }
                curr=curr.children[c-'a'];
            }
            curr.isEnd = true;
        }
    }
    
    public boolean query(char letter) {
        li.add(letter);
        if(li.size()>max_len){
            li.remove(0);
        }
        TrieNode curr =root;
        for(int i=li.size()-1;i>=0;i--){
            char c = li.get(i);
            if(curr.children[c-'a']==null)
                return false;
            if(curr.children[c-'a'].isEnd)
                return true;
            curr = curr.children[c-'a'];
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
