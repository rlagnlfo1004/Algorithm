import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        HashMap<String, Set<String>> map = new HashMap<>();
        
        for(String c[] : clothes) {
            String name = c[0];
            String type = c[1];
            
            map.putIfAbsent(type, new HashSet<>());
            map.get(type).add(name);
        }

        Iterator<Set<String>> iter = map.values().iterator();
        
        int answer = 1;
        while(iter.hasNext()) {
            Set<String> set = iter.next();
            answer *= set.size() + 1;
        }
        
        return answer - 1;
    }
}