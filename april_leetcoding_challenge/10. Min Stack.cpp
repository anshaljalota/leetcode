/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/

class MinStack {
public:
    /** initialize your data structure here. */
    stack<pair<int,int>>st;
    int min_val = INT_MAX;
    MinStack() {
        while(!st.empty()){
            st.pop();
        }
    }
    
    void push(int x) {
        if(x<min_val){
            min_val=x;
        }
        st.push(make_pair(x,min_val));
    }
    
    void pop() {
        //int temp =st.top().second;
        st.pop();
        if(st.empty()){
            min_val=INT_MAX;
        }
        else{
            min_val = st.top().second;//temp;
        }
    }
    
    int top() {
        return st.top().first;
    }
    
    int getMin() {
        return st.top().second;
        
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
