import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int rowCount = relation.length;
        int colCount = relation[0].length;
        
        List<Integer> keys = new ArrayList<>();
        
        for(int k = 1; k < (1 << colCount); k++) {
            
            boolean skip = false;
            for(int key : keys) {
                if((key & k) == key) {
                    skip = true;
                    break;
                }
            }
            if(skip) continue;
            
            Set<String> set = new HashSet<>();
            for(int row = 0; row < rowCount; row++) {
                StringBuilder sb = new StringBuilder();
                
                for(int col = 0; col < colCount; col++) {
                    if((k & (1 << col)) != 0) sb.append(relation[row][col]).append("|");
                }
                set.add(sb.toString());
            }
            if(set.size() == rowCount) keys.add(k);
        }
        return keys.size();
    }
}