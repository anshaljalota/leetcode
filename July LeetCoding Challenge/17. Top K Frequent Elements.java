/*

Given a non-empty array of integers, return the k most frequent elements.
*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int i,range = nums.length;
        int [] res = new int[k];
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(i=0;i<range;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            return b.count - a.count;
        });
        for(Map.Entry<Integer,Integer> e : hm.entrySet()){
            pq.add(new Pair(e.getKey(),e.getValue()));
        }
        i=0;
        while(k-->0){
            Pair p = pq.poll();
            res[i++] = p.getVal();
        }
        return res;
    }
}
class Pair{
    int val,count;
    public Pair(int val,int count){
        this.val = val;
        this.count=count;
    }
    public int getVal(){
        return this.val;
    }
}
