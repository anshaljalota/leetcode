/*


Design an Iterator class, which has:

A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
A function next() that returns the next combination of length combinationLength in lexicographical order.
A function hasNext() that returns True if and only if there exists a next combination.
*/

class CombinationIterator {
    ArrayList<String> res;
    int ptr,len;
    public CombinationIterator(String characters, int combinationLength) {
        this.res = new ArrayList<>();
        this.ptr = 0;
        this.len = combinationLength;
        this.util(characters,0,"");
    }
    public void util(String s, int idx, String temp){
        if(temp.length()==this.len){
            this.res.add(temp);
            return;
        }
        if(idx>=s.length())
            return;
        for(int i=idx;i<s.length();i++){
            util(s,i+1,temp + String.valueOf(s.charAt(i)));
        }
    }
    public String next() {
        return this.res.get(this.ptr++);
    }
    
    public boolean hasNext() {
        return this.ptr<this.res.size();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
