/*
We have a collection of stones, each stone has a positive integer weight.

Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
*/

class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
        int range = stones.size();
        priority_queue<int> pq;
        for(int i=0;i<range;i++)
            pq.push(stones[i]);
        int t1,t2;
        while(pq.size()>1){
            t1 = pq.top();
            pq.pop();
            t2=pq.top();
            pq.pop();
            if(t1<t2){
                pq.push(t2-t1);
            }
            else if(t2<t1)
                pq.push(t1-t2);
        }
        if(pq.size()==0)
            return 0;
        return pq.top();
    }
};
