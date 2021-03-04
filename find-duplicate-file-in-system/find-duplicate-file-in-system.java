class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String,List<String>> map = new HashMap<>();
        
        List<List<String>> output = new ArrayList<List<String>>();
        for (String info : paths) {
            String[] stuff = info.split(" ");
            
            for (int i = 1; i < stuff.length; i++) {
                String[] stuff2 = stuff[i].split("\\(");
                String content = stuff2[1].substring(0, stuff2[1].length() - 1);
                List<String> existing = map.getOrDefault(content, new ArrayList<String>());
                String file = stuff[0] + "/" + stuff2[0];
                existing.add(file);
                map.put(content, existing);
            }

        }
        
        for (String key : map.keySet()) {
            List<String> existing = map.get(key);
            if (existing.size() > 1) {
                output.add(existing);
            }
        }
        
        return output;
    }
}