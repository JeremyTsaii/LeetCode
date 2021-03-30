class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] output = new double[queries.size()];
        
        Map<String, List<Pair<String,Double>>> graph = new HashMap<>();
        
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String e1 = equation.get(0);
            String e2 = equation.get(1);
    
            List<Pair<String,Double>> existing1 = graph.getOrDefault(e1, new ArrayList<>());
            List<Pair<String,Double>> existing2 = graph.getOrDefault(e2, new ArrayList<>());

            existing1.add(new Pair<String,Double>(e2, values[i]));
            graph.put(e1, existing1);
            existing2.add(new Pair<String,Double>(e1, 1 / values[i]));
            graph.put(e2, existing2);
        }
        
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String src = query.get(0);
            String dst = query.get(1);
            
            if (!graph.containsKey(src) || !graph.containsKey(dst)) {
                output[i] = -1;
                continue;
            }
            
            Set<String> seen = new HashSet<>();
            Queue<Pair<String,Double>> q = new LinkedList<>();
            q.add(new Pair<String,Double>(src, 1.0));
            seen.add(src);
            boolean flag = true;
            while(!q.isEmpty()) {
                Pair<String,Double> node = q.poll();
                if (node.getKey().equals(dst)) {
                    output[i] = node.getValue();
                    flag = false;
                    break;
                }
                
                for (Pair<String,Double> neighbor : graph.getOrDefault(node.getKey(), new ArrayList<>())) {
                    if (!seen.contains(neighbor.getKey())) {
                        Pair<String,Double> newN = new Pair<>(neighbor.getKey(), neighbor.getValue() * node.getValue());
                        seen.add(neighbor.getKey());
                        q.add(newN);
                    }
                }
            }
            
            if (flag) {
                output[i] = -1;
            }
            
        }

        
        return output;
    }
}