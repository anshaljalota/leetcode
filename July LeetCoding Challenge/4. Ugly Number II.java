/*

Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
*/
class Solution {
    public int nthUglyNumber(int n) {
        if(n==1)
            return 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->
                                                        {return a-b;
                                                        });
        Map<Integer,Integer> m = new HashMap<>();
        int a;
        pq.add(1);
        while(n-->1){
            a = pq.poll();
            if((long)a*2<Integer.MAX_VALUE){
                if(m.getOrDefault(a*2,0)==0){
                    pq.add(a*2);
                    m.put(a*2,1);
                }
            }
            if((long)a*3<Integer.MAX_VALUE){
                if(m.getOrDefault(a*3,0)==0){
                    pq.add(a*3);
                    m.put(a*3,1);
                }
            }
            if((long)a*5<Integer.MAX_VALUE){
                if(m.getOrDefault(a*5,0)==0){
                    pq.add(a*5);
                    m.put(a*5,1);
                }
            }
        }
        return pq.poll();
    }
}
