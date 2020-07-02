/*

Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:

If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
One must use all the tickets once and only once.
*/
class Solution {
    Map<String,List<String>> hm = new HashMap<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        int range = tickets.size();
        List<String> res = new ArrayList<>();
        for(int i=0;i<range;i++){
            if(!hm.containsKey(tickets.get(i).get(0))){
                hm.put(tickets.get(i).get(0),new ArrayList<>());
            }
            hm.get(tickets.get(i).get(0)).add(tickets.get(i).get(1));
        }
        for(Map.Entry<String,List<String>> entry : hm.entrySet()){
            Collections.sort(entry.getValue());
        }
        dfs("JFK",res);
        Collections.reverse(res);
        return res;
    }
    void dfs(String str,List<String> res){
        if(hm.containsKey(str)){
            List<String> adj = hm.get(str);
            while(!adj.isEmpty()){
                dfs(adj.remove(0),res);
            }
        }
        res.add(str);
    }
}
