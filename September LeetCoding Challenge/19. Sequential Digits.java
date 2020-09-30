/*

An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
*/

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<10;i++)
            q.add(i);
        while(q.size()>0){
            int val = q.poll();
            if(val>=low && val<=high)
                res.add(val);
            int rem = val%10;
            int next_val = val*10 + rem+1;
            if(rem<9 && next_val<=high)
                q.add(next_val);
        }
        return res;
    }
}
