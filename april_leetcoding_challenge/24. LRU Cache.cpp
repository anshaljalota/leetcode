/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?
*/
class LRUCache {
public:
    int cap;
    list<int>l;
    unordered_map<int,int>m;
    LRUCache(int capacity) {
        cap = capacity;
    }
    
    int get(int key) {
        if(m.find(key)==m.end())
            return -1;
        l.remove(key);
        l.push_back(key);
        return m[key];
    }
    
    void put(int key, int value) {
        if(m.find(key)!=m.end()){
            l.remove(key);
            m.erase(key);
        }
        if(l.size()==cap){
            int val = l.front();
            l.pop_front();
              m.erase(val); 
        }
        l.push_back(key);
        m[key]=value;
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
