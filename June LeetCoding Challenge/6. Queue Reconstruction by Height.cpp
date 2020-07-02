/*

Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.
*/
class Solution {
public:
    vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {
        sort(people.begin(),people.end(),[](const vector<int>&a, const vector<int>&b){
            return (a[0]>b[0]||(a[0]==b[0] && a[1]<b[1]));
        });  
        vector<vector<int>> res;
        for(int i=0;i<people.size();i++){
            res.insert(res.begin()+people[i][1],people[i]);   
        }
        return res;
    }
};
