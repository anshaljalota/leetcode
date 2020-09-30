/*

You are given equations in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating-point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
*/

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = util(equations,values);
        double[] res = new double[queries.size()];
        
        for(int i = 0;i<queries.size();i++){
            res[i] = getVal(queries.get(i).get(0),queries.get(i).get(1),new HashSet<>(),graph);
        }
        
        return res;
        
    }
    double getVal(String start, String end, Set<String> visit,Map<String, Map<String, Double>>graph ){
        if(!graph.containsKey(start))
            return -1.0;
        if(graph.get(start).containsKey(end))
            return graph.get(start).get(end);
        visit.add(start);
        
        for(Map.Entry<String,Double> neighbor: graph.get(start).entrySet()){
            if(!visit.contains(neighbor.getKey())){
                double val = getVal(neighbor.getKey(),end,visit,graph);
                if(val!=-1.0)
                    return neighbor.getValue()*val;
            }
        }
        
        return -1.0;
    }
    Map<String, Map<String, Double>> util(List<List<String>> equations, double[] values){
        Map<String, Map<String, Double>> graph = new HashMap<>();
        String u,v;
        for(int i=0;i<equations.size();i++){
            u = equations.get(i).get(0);
            v= equations.get(i).get(1);
            graph.putIfAbsent(u, new HashMap<>());
            graph.get(u).put(v,values[i]);
            graph.putIfAbsent(v, new HashMap<>());
            graph.get(v).put(u,1/values[i]);
        }
        
        return graph;
    }
}
