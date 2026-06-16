import java.util.*;

class Solution {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    
    public int[] solution(String[] operations) {
        for(String operation : operations) {
            process(operation);
        }
        if(map.isEmpty()) return new int[] { 0, 0 };
        return new int[] { map.lastKey(), map.firstKey() };
    }
    
    void process(String operation) {
        StringTokenizer st = new StringTokenizer(operation);
        String op = st.nextToken();
        int value = Integer.parseInt(st.nextToken());
        
        if (op.equals("I")) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        } else if(op.equals("D") && value == 1) {
            if(map.isEmpty()) return;
            
            int max = map.lastKey();
            int count = map.get(max);
            if(count == 1) map.remove(max);
            else map.put(max, count - 1);
            
        } else if(op.equals("D") && value == -1) {
            if(map.isEmpty()) return;
            
            int min = map.firstKey();
            int count = map.get(min);
            if(count == 1) map.remove(min);
            else map.put(min, count - 1);
        }
    }
}