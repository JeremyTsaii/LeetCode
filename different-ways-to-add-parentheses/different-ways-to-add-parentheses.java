class Solution {
    Map<String, List<Integer>> map = new HashMap<>();
    
    public List<Integer> diffWaysToCompute(String expression) {
        if (map.containsKey(expression)) {
            return map.get(expression);
        }
        
        List<Integer> output = new ArrayList<>();
        
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            
            if (c == '+' || c == '-' || c == '*') {
                String half1 = expression.substring(0, i);
                String half2 = expression.substring(i + 1);
                
                List<Integer> half1output = diffWaysToCompute(half1);
                List<Integer> half2output = diffWaysToCompute(half2);
                
                for (int p1 : half1output) {
                    for (int p2 : half2output) {
                        if (c == '+') {
                            output.add(p1 + p2);
                        } else if (c == '-') {
                            output.add(p1 - p2);
                        } else {
                            output.add(p1 * p2);
                        }
                    }
                }
            }
        }
        
        if (output.size() == 0) {
            output.add(Integer.valueOf(expression));
        }
        map.put(expression, output);
        return output;
    }
}