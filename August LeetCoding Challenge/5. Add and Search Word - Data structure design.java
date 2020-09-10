/*

Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
*/

class WordDictionary {
    class Trie{
        Trie[] letters;
        boolean end;
        Trie(){
            letters = new Trie[26];
            end = false;
        }
    }
    /** Initialize your data structure here. */
    Trie dict;
    public WordDictionary() {
        this.dict = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie ptr = this.dict;
        for(char ch : word.toCharArray()){
            if(ptr.letters[ch-'a']==null)
                ptr.letters[ch-'a'] = new Trie();
            ptr=ptr.letters[ch-'a'];
        }
        ptr.end = true;
    }
    boolean util(Trie ptr, String word, int idx){
        if(idx>=word.length())
            return ptr.end;
        char ch = word.charAt(idx);
        if(ch=='.'){
            for(Trie t: ptr.letters){
                if(t!=null && util(t,word,idx+1))
                    return true;
            }
            return false;
        }
        if(ptr==null|| ptr.letters[ch-'a']==null)
            return false;
        return util(ptr.letters[ch-'a'],word,idx+1);    
    }
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return util(this.dict,word,0);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
