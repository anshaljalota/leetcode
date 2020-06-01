/*
Implement a trie with insert, search, and startsWith methods.
*/

class Trie {
public:
    /** Initialize your data structure here. */
    Trie *child[26];
    bool isEnd;
    Trie() {
        isEnd = false;
        for(int i=0;i<26;i++)
            child[i]=NULL;
    }
    Trie* root=NULL;
    /** Inserts a word into the trie. */
    void insert(string word) {
        if(!root)
            root = new Trie();
        Trie *ptr = root;
        for(char ch:word){
            if(!ptr->child[ch-'a'])
                ptr->child[ch-'a']= new Trie();
            ptr = ptr->child[ch-'a'];
        }
        ptr->isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        if(!root)
            return false;
        Trie * ptr = root;
        for(char ch: word){
            if(!ptr->child[ch-'a'])
                return false;
            ptr = ptr->child[ch-'a'];
        }
        return ptr->isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        if(!root)
            return false;
        Trie * ptr = root;
        for(char ch: prefix){
            if(!ptr->child[ch-'a'])
                return false;
             ptr = ptr->child[ch-'a'];
        }
        return true;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */
